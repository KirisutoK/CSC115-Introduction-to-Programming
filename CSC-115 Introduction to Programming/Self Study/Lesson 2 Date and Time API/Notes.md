# Basic Class (Introduction to Programming)
## Lesson 2: Date and Time API

---

## 1. The Modern API — `java.time`

Since Java 8, the `java.time` package replaced the old, error-prone `Date` and `Calendar` classes. The key classes:

| Class | Represents |
|---|---|
| `LocalDate` | A date only (year, month, day) — no time, no timezone |
| `LocalTime` | A time only (hour, minute, second) — no date, no timezone |
| `LocalDateTime` | A date and time combined — no timezone |
| `ZonedDateTime` | A date and time with a specific timezone |
| `Duration` | A time-based amount (hours, minutes, seconds) |
| `Period` | A date-based amount (years, months, days) |

All of these are **immutable**, same as `String` — every "modification" method returns a new object instead of changing the original.

---

## 2. Creating Dates and Times

```java
LocalDate today = LocalDate.now();                  // current date
LocalDate specific = LocalDate.of(2026, 8, 14);      // year, month, day
LocalDate specific2 = LocalDate.of(2026, Month.AUGUST, 14); // using Month enum

LocalTime now = LocalTime.now();
LocalTime specificTime = LocalTime.of(14, 30, 0);    // hour, minute, second

LocalDateTime dt = LocalDateTime.now();
LocalDateTime dtSpecific = LocalDateTime.of(2026, 8, 14, 14, 30);
```

---

## 3. Getting Components

```java
LocalDate date = LocalDate.of(2026, 8, 14);

date.getYear();        // 2026
date.getMonth();       // AUGUST (a Month enum)
date.getMonthValue();  // 8
date.getDayOfMonth();  // 14
date.getDayOfWeek();   // FRIDAY (a DayOfWeek enum)
date.getDayOfYear();   // 226
```

---

## 4. Modifying Dates (Immutability in Action)

Since these classes are immutable, every "change" returns a **new object** — just like `String`.

```java
LocalDate date = LocalDate.of(2026, 8, 14);

LocalDate nextWeek = date.plusDays(7);
LocalDate lastMonth = date.minusMonths(1);
LocalDate nextYear = date.plusYears(1);

date.plusDays(7); // does NOTHING to `date` itself — return value discarded!
System.out.println(date); // still 2026-08-14
```

Common modification methods: `.plusDays()`, `.minusDays()`, `.plusWeeks()`, `.plusMonths()`, `.plusYears()`, and their `minus` counterparts, plus `.withYear()`, `.withMonth()`, `.withDayOfMonth()` (set a specific field directly).

---

## 5. Comparing Dates

```java
LocalDate a = LocalDate.of(2026, 8, 14);
LocalDate b = LocalDate.of(2026, 12, 25);

a.isBefore(b);   // true
a.isAfter(b);    // false
a.isEqual(b);    // false
a.equals(b);     // false — also works, same as isEqual for LocalDate
```

---

## 6. Duration vs Period

- **`Period`** — difference between two dates (years/months/days)
- **`Duration`** — difference between two times (hours/minutes/seconds), or between two `LocalDateTime`/`Instant` objects

```java
LocalDate start = LocalDate.of(2026, 1, 1);
LocalDate end = LocalDate.of(2026, 8, 14);

Period period = Period.between(start, end);
period.getMonths();  // 7
period.getDays();    // 13

LocalTime t1 = LocalTime.of(9, 0);
LocalTime t2 = LocalTime.of(17, 30);

Duration duration = Duration.between(t1, t2);
duration.toHours();   // 8
duration.toMinutes(); // 510
```

---

## 7. Formatting and Parsing

`DateTimeFormatter` converts between `LocalDate`/`LocalDateTime` and `String`.

```java
LocalDate date = LocalDate.of(2026, 8, 14);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
String formatted = date.format(formatter); // "08/14/2026"

LocalDate parsed = LocalDate.parse("08/14/2026", formatter);
```

Common pattern letters: `yyyy` (year), `MM` (month), `dd` (day), `HH` (hour, 24h), `mm` (minute), `ss` (second), `EEEE` (full day name, e.g. "Friday"), `MMMM` (full month name, e.g. "August").

---

## 8. Working with Timezones

```java
ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/New_York"));
ZonedDateTime other = zdt.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
```

`ZoneId.of("...")` takes a standard timezone ID (e.g. `"America/New_York"`, `"Europe/London"`, `"UTC"`).

---

## 9. What I'm Testing Next

Your upcoming practice/problems will test:
- Creating and modifying dates/times using the immutable, chainable style
- Correctly using `Period` vs `Duration` for the right kind of difference
- Formatting dates into custom String patterns and parsing them back
- Comparing dates/times correctly