
from fastapi import FastAPI
from pydantic import BaseModel
from model import CustomerCommentAnalyzer

app = FastAPI(title="Customer Feedback Analyzer")

# Input model for requests
class FeedbackRequest(BaseModel):
    comment: str

# Output model (not strictly enforced, just for docs)
class FeedbackResponse(BaseModel):
    original_text: str
    sentiment: str
    satisfaction: str
    improvement_suggestions: list[str]
    product_quality: str
    key_insights: list[str]

# Initialize analyzer
analyzer = CustomerCommentAnalyzer(api_key="")

@app.post("/analyze", response_model=FeedbackResponse)
def analyze_feedback(request: FeedbackRequest):
    result = analyzer.analyze_comment(request.comment)
    return result