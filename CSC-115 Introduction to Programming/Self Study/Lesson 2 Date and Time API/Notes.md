# **Lesson 2: Date and Time API**

Java's `java.time` package gives you powerful, reliable tools for working with dates and times.
(Think: A built-in calendar and clock for your program — and everything is immutable, just like `String`)

---

## **Why `java.time`?**

Before Java 8, developers used `Date` and `Calendar` — both were buggy, confusing, and hard to use correctly. Since Java 8, `java.time` replaced them entirely. In production, you will almost never touch the old classes.

```java
import java.time.*;        // imports all date/time classes
import java.time.format.*; // imports DateTimeFormatter
```

---

## **1. LocalDate**

Represents a **date only** — year, month, and day. No time, no timezone.

```java
LocalDate today    = LocalDate.now();                          // current date
LocalDate specific = LocalDate.of(2026, 8, 14);                // year, month, day
LocalDate specific = LocalDate.of(2026, Month.AUGUST, 14);     // using Month enum
```

**Getting components:**
```java
LocalDate date = LocalDate.of(2026, 8, 14);

date.getYear();        // 2026
date.getMonth();       // AUGUST (Month enum)
date.getMonthValue();  // 8
date.getDayOfMonth();  // 14
date.getDayOfWeek();   // FRIDAY (DayOfWeek enum)
date.getDayOfYear();   // 226
```

**Modifying:**
```java
date.plusDays(7);       // 7 days later
date.minusMonths(1);    // 1 month earlier
date.plusYears(1);      // 1 year later
date.withDayOfMonth(1); // set day to 1st, same month and year
```

> ⚠️ All `java.time` classes are **immutable** — always reassign the result or the change is lost!
> ```java
> date.plusDays(7); // does NOTHING — return value discarded!
> date = date.plusDays(7); // ✅ correct
> ```

**Comparing:**
```java
LocalDate a = LocalDate.of(2026, 8, 14);
LocalDate b = LocalDate.of(2026, 12, 25);

a.isBefore(b);  // true
a.isAfter(b);   // false
a.isEqual(b);   // false
a.equals(b);    // false — same as isEqual for LocalDate
```

---

## **2. LocalTime**

Represents a **time only** — hour, minute, second. No date, no timezone.

```java
LocalTime now     = LocalTime.now();
LocalTime specific = LocalTime.of(14, 30, 0); // hour, minute, second
```

**Getting components:**
```java
LocalTime time = LocalTime.of(14, 30, 45);

time.getHour();    // 14
time.getMinute();  // 30
time.getSecond();  // 45
```

**Modifying:**
```java
time.plusHours(2);     // 2 hours later
time.minusMinutes(15); // 15 minutes earlier
time.withHour(9);      // set hour to 9, same minute and second
```

---

## **3. LocalDateTime**

Represents a **date and time combined** — no timezone.
(Think: `LocalDate` + `LocalTime` merged into one object)

```java
LocalDateTime now      = LocalDateTime.now();
LocalDateTime specific = LocalDateTime.of(2026, 8, 14, 14, 30);       // year, month, day, hour, minute
LocalDateTime specific = LocalDateTime.of(2026, 8, 14, 14, 30, 0);    // with seconds
```

**You can also combine existing LocalDate and LocalTime:**
```java
LocalDate date = LocalDate.of(2026, 8, 14);
LocalTime time = LocalTime.of(14, 30);

LocalDateTime dt = LocalDateTime.of(date, time);
LocalDateTime dt = date.atTime(time);          // alternative
LocalDateTime dt = date.atStartOfDay();        // attaches 00:00:00 as the time
```

**Getting components** — same as `LocalDate` and `LocalTime` combined:
```java
dt.getYear();
dt.getMonthValue();
dt.getDayOfMonth();
dt.getHour();
dt.getMinute();
```

---

## **4. Period**

Represents a **date-based amount** — years, months, and days.
Use `Period` when measuring the difference between two **dates**.

```java
LocalDate start = LocalDate.of(2026, 1, 1);
LocalDate end   = LocalDate.of(2026, 8, 14);

Period period = Period.between(start, end);
period.getYears();   // 0
period.getMonths();  // 7
period.getDays();    // 13
```

**Creating a Period directly:**
```java
Period p = Period.of(1, 2, 3); // 1 year, 2 months, 3 days
LocalDate future = LocalDate.now().plus(p);
```

---

## **5. Duration**

Represents a **time-based amount** — hours, minutes, and seconds.
Use `Duration` when measuring the difference between two **times**.

```java
LocalTime t1 = LocalTime.of(9, 0);
LocalTime t2 = LocalTime.of(17, 30);

Duration duration = Duration.between(t1, t2);
duration.toHours();   // 8
duration.toMinutes(); // 510 — total minutes, not just the remainder!
```

> 💡 `Duration.between()` also works with two `LocalDateTime` objects — useful when the time difference crosses midnight, since `LocalTime` alone can't represent that crossing.

**Creating a Duration directly:**
```java
Duration d = Duration.ofHours(3);
Duration d = Duration.ofMinutes(90);

LocalTime later = LocalTime.now().plus(d);
```

---

## **6. Formatting and Parsing**

`DateTimeFormatter` converts between date/time objects and `String` in both directions.

```java
LocalDate date = LocalDate.of(2026, 8, 14);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

// Format → String
String formatted = date.format(formatter); // "08/14/2026"

// Parse → LocalDate
LocalDate parsed = LocalDate.parse("08/14/2026", formatter);
```

**Common pattern letters:**

| Pattern | Meaning            | Example |
|---------|--------------------|---------|
| `yyyy`  | Year               | 2026    |
| `MM`    | Month (number)     | 08      |
| `MMMM`  | Month (full name)  | August  |
| `dd`    | Day of month       | 14      |
| `EEEE`  | Day of week (full) | Friday  |
| `a`      | Day of Time        | AM/PM   |
| `HH`    | Hour (24h)         | 14      |
| `hh`    | Hour (12h)         | 14      |
| `mm`    | Minute             | 30      |
| `ss`    | Second             | 00      |

> ⚠️ When parsing a pattern with `EEEE`, the day name in your string must actually match the date — Java throws a `DateTimeParseException` if they don't match.

---

## **7. ZonedDateTime**

Represents a **date and time with a timezone** — use this when your program needs to work across different regions.

```java
ZonedDateTime zdt   = ZonedDateTime.now(ZoneId.of("America/New_York"));
ZonedDateTime tokyo = zdt.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
```

Common timezone IDs: `"America/New_York"`, `"Europe/London"`, `"Asia/Tokyo"`, `"UTC"`

to find all the available timezones that java currently has (not UTC):
````java
ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
````

---

## **📋 Key Rules:**

- All `java.time` classes are **immutable** — always reassign after modification
- Use `Period` for date differences, `Duration` for time differences — never mix them up
- `Duration.toMinutes()` returns the **total** minutes, not just the remainder after hours
- Always use `DateTimeFormatter` for formatting/parsing — never manually build date strings

---

## **🗺️ Quick Reference:**

```
Need just a date?              → LocalDate
Need just a time?              → LocalTime
Need date AND time?            → LocalDateTime
Need timezone awareness?       → ZonedDateTime

Difference between two dates?  → Period
Difference between two times?  → Duration

Convert to/from String?        → DateTimeFormatter
```