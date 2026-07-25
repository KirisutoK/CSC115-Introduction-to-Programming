# 📝 Lesson 10 Quiz — File I/O and Serialization

---

## 📌 Instructions
- Read each question carefully
- Choose the **best answer** from the options provided
- Fill in your answers in the **My Answers** section at the bottom

---

## ❓ Questions

---

### Question 1
What does "I/O" stand for in File I/O?

- A) Internal/Output
- B) Input/Output
- C) Integer/Object
- D) Import/Override

---

### Question 2
Which class do you use to **efficiently read a text file line by line**?

- A) `FileReader`
- B) `PrintWriter`
- C) `BufferedReader`
- D) `ObjectInputStream`

---

### Question 3
What does this line do?

```java
new FileWriter("myfile.txt", true)
```

- A) Creates a new file and overwrites existing content
- B) Opens the file in append mode — adds to existing content
- C) Reads from the file
- D) Deletes the file and creates a new one

---

### Question 4
What is the purpose of **try-with-resources** when working with files?

- A) It makes file operations faster
- B) It automatically closes the file when the try block finishes
- C) It catches all exceptions automatically
- D) It creates the file if it doesn't exist

---

### Question 5
What does `BufferedReader.readLine()` return when it reaches the end of the file?

- A) An empty String `""`
- B) `0`
- C) `null`
- D) It throws an exception

---

### Question 6
What must a class do to support **Serialization**?

- A) Extend `Serializable`
- B) Implement `Serializable`
- C) Import `Serializable`
- D) Override `Serializable`

---

### Question 7
Which class is used to **save a Java object** to a file?

- A) `FileWriter`
- B) `BufferedWriter`
- C) `ObjectOutputStream`
- D) `PrintWriter`

---

### Question 8
What does the `transient` keyword do in a Serializable class?

- A) Makes the field save faster
- B) Marks the field to be excluded from serialization
- C) Makes the field read-only
- D) Converts the field to a String before saving

---

### Question 9
What will `File.exists()` return if the file has been deleted?

- A) `true`
- B) `null`
- C) It throws a `FileNotFoundException`
- D) `false`

---

### Question 10
What exception must you always handle (or declare) when working with File I/O?

- A) `NullPointerException`
- B) `ArithmeticException`
- C) `IOException`
- D) `ClassCastException`

---

### Question 11
What does `readObject()` throw that `readLine()` does NOT?

- A) `IOException`
- B) `FileNotFoundException`
- C) `ClassNotFoundException`
- D) `NullPointerException`

---

### Question 12
What is the difference between `FileWriter` and `PrintWriter`?

- A) `FileWriter` is faster, `PrintWriter` is slower
- B) `PrintWriter` provides convenient methods like `println()`, `FileWriter` only writes raw characters
- C) `FileWriter` can only write numbers, `PrintWriter` can only write Strings
- D) They are exactly the same

---

## ✏️ My Answers

| Question | My Answer |
|----------|-----------|
| 1        | B         |
| 2        | C         |
| 3        | B         |
| 4        | C         |
| 5        | C         |
| 6        | B         |
| 7        | C         |
| 8        | B         |
| 9        | D         |
| 10       | C         |
| 11       | C         |
| 12       | B         |

---

## ✅ Correct Answers
*(Fill this in after receiving feedback from Professor Claude)*

| Question | Correct Answer | Explanation |
|----------|----------------|-------------|
| 1        |                |             |
| 2        |                |             |
| 3        |                |             |
| 4        |                |             |
| 5        |                |             |
| 6        |                |             |
| 7        |                |             |
| 8        |                |             |
| 9        |                |             |
| 10       |                |             |
| 11       |                |             |
| 12       |                |             |