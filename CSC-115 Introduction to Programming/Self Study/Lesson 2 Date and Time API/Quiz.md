# 📝 Lesson 2 Quiz — Date and Time API

---

## 📌 Instructions
- Read each question carefully
- Choose the **best answer** from the options provided
- Fill in your answers in the **My Answers** section at the bottom

---

## ❓ Questions

---

### Question 1
What is the key difference between `LocalDateTime` and `ZonedDateTime`?

- A) `LocalDateTime` stores timezone information, `ZonedDateTime` does not
- B) `ZonedDateTime` includes timezone information, `LocalDateTime` does not
- C) They are exactly the same, just different names
- D) `LocalDateTime` can only store dates, not times

---

### Question 2
What will the following code print?

```java
LocalDate date = LocalDate.of(2026, 8, 14);
date.plusDays(10);
System.out.println(date);
```

- A) `2026-08-24`
- B) `2026-08-14`
- C) Compilation error
- D) `null`

---

### Question 3
Which is the correct way to use `Period` and `Duration`?

- A) `Period` for time differences, `Duration` for date differences
- B) `Period` for date differences, `Duration` for time differences
- C) Both can be used interchangeably for dates and times
- D) `Period` is for years only, `Duration` is for seconds only

---

### Question 4
What does `Duration.toMinutes()` return?

- A) Only the minutes component, not including hours
- B) The total minutes of the entire duration
- C) The minutes rounded to the nearest hour
- D) Always returns 60

---

### Question 5
What will this code print?

```java
LocalDate a = LocalDate.of(2026, 1, 1);
LocalDate b = LocalDate.of(2026, 8, 14);
Period p = Period.between(a, b);
System.out.println(p.getMonths());
```

- A) 226
- B) 13
- C) 7
- D) 8

---

### Question 6
What is the correct way to convert a `ZonedDateTime` from one timezone to another while keeping the same instant in time?

- A) `.withZoneSameLocal()`
- B) `.withZoneSameInstant()`
- C) `.convertTimezone()`
- D) `.toZone()`

---

### Question 7
What does `date.atStartOfDay()` return?

- A) A `LocalTime` set to `00:00:00`
- B) A `LocalDate` with the time removed
- C) A `LocalDateTime` with the time set to `00:00:00`
- D) A `ZonedDateTime` at midnight UTC

---

### Question 8
Which `DateTimeFormatter` pattern correctly formats a date as `"Friday, August 14 2026"`?

- A) `"EEEE, MMMM dd yyyy"`
- B) `"EEE, MMM d yyyy"`
- C) `"DAY, MONTH dd yyyy"`
- D) `"dddd, MMMM dd yyyy"`

---

### Question 9
What exception is thrown when parsing a date string that doesn't match the formatter pattern?

- A) `IllegalArgumentException`
- B) `ParseException`
- C) `DateTimeParseException`
- D) `FormatException`

---

### Question 10
What is the correct way to get the total number of days between two `LocalDate` objects?

- A) `Period.between(a, b).getDays()`
- B) `ChronoUnit.DAYS.between(a, b)`
- C) `Duration.between(a, b).toDays()`
- D) `a.getDayOfYear() - b.getDayOfYear()`

---

## ✏️ My Answers

| Question | My Answer |
|----------|-----------|
| 1        | B         |
| 2        | A         |
| 3        | B         |
| 4        | B         |
| 5        | C         |
| 6        | B         |
| 7        | C         |
| 8        | A         |
| 9        | C         |
| 10       | B         |

---

## ✅ Correct Answers
*(Fill this in after receiving feedback from Professor Claude)*

| Question | Correct Answer | Explanation                          |
|----------|----------------|--------------------------------------|
| 1        | B              | 	✅                                   |
| 2        | B              | ❌   Date and Time APIs are Immutable |
| 3        | B              | 	✅                                   |
| 4        | B              | 	✅                                   |
| 5        | C              | 	✅                                   |
| 6        | B              | 	✅                                   |
| 7        | C              | 	✅                                   |
| 8        | A              | 	✅                                   |
| 9        | C              | 	✅                                   |
| 10       | B              | 	✅                                   |