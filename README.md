# Spring Boot Apache Kafka Wikimedia Project

This project demonstrates a **real-time event-driven microservices architecture** using **Spring Boot** and **Apache Kafka**, with **live Wikimedia data** as the source of events.

## Overview

The system consists of two main components:

- **Producer Service**  
  - Fetches live Wikimedia events in real-time.  
  - Publishes these events/messages to an **Apache Kafka** topic.  

- **Consumer Service**  
  - Subscribes to the Kafka topic.  
  - Processes incoming Wikimedia events in real-time (e.g., logging, analysis, or storage).  

This architecture showcases **streaming data pipelines**, **asynchronous communication**, and **scalable microservices** in action.

---

## Technologies Used

- Java 17  
- Spring Boot  
- Apache Kafka  
- Wikimedia EventStream API  

---
