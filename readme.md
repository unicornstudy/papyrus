
# Papyrus

### 프로젝트 소개

Papyrus 는 포털 사이트의 뉴스 기사들을 수집하여, 뉴스 요약 기능과 검색을 제공하는 서비스입니다.

---

### 프로젝트 목표
- Node.js 를 통해 뉴스를 크롤링하여 수집합니다.
- Redis 캐싱 처리를 통해 뉴스 중복 크롤링을 방지합니다.
- 크롤링 된 뉴스들은 RabbitMQ 에 저장합니다.
- SpringBoot 에서 RabbitMQ에 저장된 기사들을 ElasticSearch 와 PostgreSQL DB 에 저장합니다.
- ElasticSearch 에서 형태소 분석기를 통해 보다 향상된 한글 검색을 지원합니다.
- ChatGPT, KoGPT를 통해 뉴스 기사 요약 기능을 제공합니다.

---

### 기술 스택


![image](https://github.com/unicornstudy/papyrus/assets/91658692/496ab1d6-e821-497c-a980-6b58b5120546)

