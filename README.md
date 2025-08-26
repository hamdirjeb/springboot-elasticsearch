# 📚 Student Search with Spring Boot & Elasticsearch

This project demonstrates how to integrate **Spring Boot** with **Elasticsearch** using the official Java API client.  
It provides a REST API for indexing and searching `Student` documents.

---

## 🚀 Features
- Index students into Elasticsearch
- Search students by name with wildcards (`*name*`)
- Clean Spring Boot service layer
- REST API endpoints for easy testing
- Uses **Elasticsearch Java API client** (`co.elastic.clients:elasticsearch-java`)

---

## 🛠️ Tech Stack
- **Java 21** (or 17+)
- **Spring Boot 3**
- **Elasticsearch** (8.x+)
- **Elasticsearch Java API Client**

---

## 🚀 How to Run (Locally)

### 1. Start Elasticsearch (Docker recommended)
```bash
docker run -p 9200:9200 -e "discovery.type=single-node" \
  -e "xpack.security.enabled=false" \
  docker.elastic.co/elasticsearch/elasticsearch:8.13.4