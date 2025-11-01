![e commerce (1)](https://github.com/user-attachments/assets/dc73e95d-b3d5-479e-a872-69ef2fc10fa5)
🛍️ E-Commerce Platform

An AI-integrated e-commerce platform for selling clothing items, designed with a microservices architecture to ensure scalability and modularity.
The system combines Spring Boot and FastAPI backends, with Kafka for inter-service communication, Observer Pattern for notification handling, and an LLM-powered review analysis component.

🚀 Overview

This project is a modern e-commerce solution that manages products, orders, notifications, and intelligent customer feedback analysis.
It demonstrates a hybrid architecture where Java (Spring Boot) and Python (FastAPI) microservices work together efficiently.

🧩 Architecture

Main Backend: Spring Boot

Core business logic (products, orders, users, and payments)

Exposes REST APIs for frontend communication

Review Analysis Microservice: FastAPI

Extracts and processes customer reviews

Integrates with an LLM (Large Language Model) to analyze feedback and provide insights

Communicates results back to the main backend

Notification Microservice: Spring Boot

Implements the Observer Design Pattern to handle event-driven notifications

Listens for events from other services and sends email/SMS updates

Uses Apache Kafka for asynchronous communication between microservices

⚙️ Tech Stack

Java (Spring Boot) – Core backend and notification service

Python (FastAPI) – AI-based review analysis microservice

Apache Kafka – Message broker for event-driven communication

LLM Integration – For customer review understanding and summarization

PostgreSQL / MySQL – Database

Docker (optional) – Containerized deployment environment

💡 Key Features

🧵 Product and order management

💬 LLM-powered review analysis

📢 Event-driven notifications using Kafka

👀 Observer Pattern for notification updates

🧠 Hybrid microservice architecture (Spring Boot ↔ FastAPI)

⚡ Modular and scalable backend design

⚠️ Note

Security and authentication are not yet implemented.
Future versions will include JWT-based authentication and gateway-level access control.
