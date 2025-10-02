from groq import Groq
import json



class CustomerCommentAnalyzer:
    def __init__(self, api_key=None):
        """Initialize the Groq client"""
        self.client = Groq(api_key=api_key) if api_key else Groq()
    
    def analyze_comment(self, customer_comment: str):
        """
        Analyze customer comment and return ONE unified structured JSON response
        """
        prompt = f"""
You are a customer feedback analyzer.

Analyze the following customer comment as ONE whole statement (not sentence by sentence). 
You must return ONE single JSON object, nothing else. Do not include multiple JSON objects, explanations, or extra text.

Customer Comment: "{customer_comment}"

Return JSON with this exact structure:
{{
  "original_text": "the complete comment as given",
  "sentiment": "positive/negative/neutral/mixed",
  "satisfaction": "satisfied/unsatisfied/neutral (with brief reason)",
  "improvement_suggestions": ["list of improvements mentioned"],
  "product_quality": "excellent/good/average/poor (with reasoning)",
  "key_insights": ["hidden feedback, underlying concerns, or unspoken needs"]
}}
"""

        try:
            completion = self.client.chat.completions.create(
                model="llama-3.3-70b-versatile",
                messages=[
                    {
                        "role": "system",
                        "content": "Always respond with exactly ONE valid JSON object. No extra text."
                    },
                    {
                        "role": "user",
                        "content": prompt
                    }
                ],
                temperature=0.2,
                max_completion_tokens=512,
                stream=False
            )
            
            response_text = completion.choices[0].message.content.strip()

            # Extract only JSON if extra formatting slips through
            if response_text.startswith("```"):
                response_text = response_text.strip("`").replace("json", "").strip()
            
            return json.loads(response_text)

        except json.JSONDecodeError as e:
            return {"error": f"JSON parsing failed: {e}", "raw_response": response_text}
        except Exception as e:
            return {"error": str(e)}



