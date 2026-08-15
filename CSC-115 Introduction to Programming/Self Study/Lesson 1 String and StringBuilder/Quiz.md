# 📝 Lesson 1 Quiz — String and StringBuilder

---

## 📌 Instructions
- Read each question carefully
- Choose the **best answer** from the options provided
- Fill in your answers in the **My Answers** section at the bottom

---

## ❓ Questions

---

### Question 1
What will the following code print?

```java
String s = "Java";
s.concat(" Rocks");
System.out.println(s);
```

- A) `Java Rocks`
- B) `Java`
- C) `null`
- D) Compilation error

---

### Question 2
Why does `a == b` return `false` in this code?

```java
String a = new String("cat");
String b = "cat";
System.out.println(a == b);
```

- A) Because the two Strings have different lengths
- B) Because `==` compares object references, and `new String()` creates a separate object
- C) Because Strings can never be compared with `==`
- D) Because `b` is a literal and `a` is not, so Java throws an error

---

### Question 3
Which is generally the better choice for building a large string inside a loop, and why?

- A) `String` with `+=`, because it's simpler to read
- B) `StringBuilder` with `.append()`, because it modifies one object instead of creating a new one each time
- C) They perform exactly the same
- D) `String` with `+=`, because Strings are faster than StringBuilder

---

### Question 4
What does the following code produce?

```java
StringBuilder sb = new StringBuilder("Hello");
sb.insert(0, "Well, ").append("!");
System.out.println(sb);
```

- A) `Well, Hello!`
- B) `Hello Well, !`
- C) `Well, Hello`
- D) Compilation error — `insert` and `append` cannot be chained

---

### Question 5
Given:

```java
StringBuilder sb = new StringBuilder("banana");
sb.deleteCharAt(0);
sb.reverse();
System.out.println(sb);
```

What is printed?

- A) `ananab`
- B) `ananb`
- C) `bananab`
- D) `ananab` reversed again

---

### Question 6
True or False: `.equals()` compares memory addresses, while `==` compares content, for String objects.

- A) True
- B) False

---

### Question 7
What method would you use to convert a `StringBuilder` back into an immutable `String`?

- A) `.build()`
- B) `.finalize()`
- C) `.toString()`
- D) `.convert()`

---

### Question 8
Strings in Java are considered ______, meaning once created, their value cannot change.

- A) Static
- B) Immutable
- C) Final
- D) Constant

---

## ✏️ My Answers

| Question | My Answer                        |
|----------|----------------------------------|
| 1        | A                                |
| 2        | B                                |
| 3        | B                                |
| 4        | A                                |
| 5        | ? I am pretty sure this is anana |
| 6        | B                                |
| 7        | C                                |
| 8        | B                                |

---

## ✅ Correct Answers
*(Fill this in after receiving feedback from Professor Claude)*

| Question | Correct Answer | Explanation |
|----------|----------------|-------------|
| 1        | B              | ❌           |
| 2        | B              | 	✅          |
| 3        | B              | 	✅          |
| 4        | A              | ✅           |
| 5        | anana          | ✅           |
| 6        | B              | ✅           |
| 7        | C              | ✅           |
| 8        | B              | ✅           |