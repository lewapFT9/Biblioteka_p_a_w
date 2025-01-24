# Backend Aplikacji  

## 📌 Opis projektu  
Backend aplikacji został stworzony w **Java (Spring Boot)**, wykorzystując **Maven** do zarządzania zależnościami oraz **MySQL** jako bazę danych.  
Baza danych jest hostowana na platformie **Railway** i została wygenerowana na podstawie klas w Javie przy użyciu **IntelliJ IDEA**, wykorzystując mechanizm **migracji**.

## 🛠 Technologie  
- **Java 23.0.1**  
- **Spring Boot**  
- **Maven 3.9.9**  
- **MySQL (hostowany na Railway)**  
- **Hibernate (ORM)**  

## 📦 Instalacja  

### 1️⃣ Wymagania wstępne  
Przed uruchomieniem backendu upewnij się, że masz zainstalowane:  
- **Maven 3.9.9**  
- **Java 23.0.1**  

### 2️⃣ Instalacja zależności  
```bash
mvn clean instal
```
### 3️⃣ Uruchomienie aplikacji  
```bash
mvn spring-boot:run
```
📂 Struktura projektu
📦 backend
 ┣ 📂 src/main/java/com/example
 ┣ ┣ 📂 config  # Konfiguracja JWT oraz ustawień sieciowych(role autoryzacja itp.)
 ┃ ┣ 📂 controllers  # Kontrolery API
 ┃ ┣ 📂 services     # Logika biznesowa
 ┃ ┣ 📂 models       # Klasy encji (Hibernate)
 ┃ ┣ 📂 repositories # Interfejsy dostępu do bazy
 ┃ ┗ 📜 Application.java # Klasa startowa
 ┣ 📜 pom.xml  # Konfiguracja Maven
 ┗ 📜 application.properties  # Konfiguracja aplikacji
