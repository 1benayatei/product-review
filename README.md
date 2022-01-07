# Product Review

Sample project for define configuration of product, you can set visible, commentable, votable and other for each product.
Also, can store comment and vote for each product.


## Entities
- ProductConfig
- Comment
- Vote

## Tech Stack

**Server:** Java, Spring

**Database:** Postgres


## Run Locally

Clone the project

```bash
  git clone git@github.com:1benayatei/product-review.git
```

Go to the project directory

```bash
  cd product-review
```

### Environment Variables

To run this project, you will need to add the following environment variables to your application.properties file

`DB_HOST`

`DB_PORT`

`DB_NAME`

`DB_USERNAME`

`DB_PASSWORD`

Install dependencies

```bash
  ./mvnw clean pacakge
```

Run

```bash
  ./mvnw spring-boot:run
```

## Installation

Install dependency with maven

```bash
  ./mvnw clean package
```