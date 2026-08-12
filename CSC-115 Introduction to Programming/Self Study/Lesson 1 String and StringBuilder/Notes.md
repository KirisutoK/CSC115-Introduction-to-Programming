# Basic Class (Introduction to Programming)
## Lesson 1: String and StringBuilder

---

## 1. Strings Are Immutable

A `String` in Java **cannot be changed once created**. Every method that looks like it "modifies" a String actually creates and returns a **brand new** String object.

```java
String name = "Java";
name.concat(" Rocks"); // does nothing to `name` — return value is discarded!
System.out.println(name); // still prints "Java"

name = name.concat(" Rocks"); // now it works, because we reassigned
System.out.println(name); // "Java Rocks"
```

**Why does this matter?**
- Every `+`, `.toUpperCase()`, `.trim()`, `.substring()`, `.replace()`, etc. creates a new object in memory.
- If you do this repeatedly (e.g., in a loop), you're creating a lot of throwaway objects — wasteful and slow.

```java
String result = "";
for (int i = 0; i < 10000; i++) {
    result += i; // creates a NEW String object on every single iteration
}
```

This pattern is a common performance trap for beginners.

---

## 2. StringBuilder Is Mutable

`StringBuilder` solves the above problem. It holds an internal, resizable character buffer and **modifies it in place** instead of creating new objects.

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append(i); // modifies the SAME object every time
}
String result = sb.toString(); // convert back to String only once, at the end
```

**Key methods:**

| Method | What it does |
|---|---|
| `.append(x)` | Adds `x` to the end (returns the same StringBuilder, so it's chainable) |
| `.insert(index, x)` | Inserts `x` at a specific position |
| `.delete(start, end)` | Removes characters in that range |
| `.deleteCharAt(index)` | Removes a single character |
| `.reverse()` | Reverses the entire sequence |
| `.replace(start, end, str)` | Replaces a range with a new string |
| `.toString()` | Converts back to an immutable `String` |
| `.length()` | Current number of characters |
| `.charAt(index)` | Gets a specific character |

**Method chaining example:**
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("World").reverse();
System.out.println(sb.toString()); // "dlroW olleH"
```

---

## 3. When to Use Which

| Situation | Use |
|---|---|
| Value won't change, or changes rarely | `String` |
| Building/modifying text repeatedly (loops, parsing, building output) | `StringBuilder` |
| Multithreaded environment needing thread-safety | `StringBuffer` (same API as StringBuilder, but synchronized — slower, rarely needed unless multiple threads touch the same buffer) |

---

## 4. Common String Methods Worth Knowing

```java
String s = "  Hello, Java World!  ";

s.length();              // 22 (includes the spaces)
s.trim();                // "Hello, Java World!" (removes leading/trailing whitespace)
s.strip();                // same as trim(), but Unicode-aware (Java 11+)
s.toUpperCase();          // "  HELLO, JAVA WORLD!  "
s.toLowerCase();          // "  hello, java world!  "
s.contains("Java");       // true
s.indexOf("Java");        // position of first occurrence
s.lastIndexOf("Java");    // Searchs up all the 'java' words and returns the starting point of the int where it was found last.
s.replace("Java", "C#");  // replaces all occurrences
s.split(",");             // splits into a String array by delimiter
s.substring(2, 7);        // characters from index 2 up to (not including) 7
s.charAt(0);              // character at index 0
s.equals("Hello");        // content comparison (use this, NOT ==, for Strings!)
s.equalsIgnoreCase("HELLO"); // case-insensitive comparison
```

### ⚠️ Important: `==` vs `.equals()`

```java
String a = new String("test");
String b = new String("test");

a == b;         // false! compares memory references, not content
a.equals(b);    // true — compares actual content
```

Always use `.equals()` to compare String *content*.

---

## 5. What I'm Testing Next

Your upcoming challenge(s) will test:
- Correctly choosing between `String` and `StringBuilder` based on the situation
- Using core `StringBuilder` methods (`append`, `insert`, `delete`, `reverse`, etc.)
- Understanding immutability and why certain operations "don't work" if you forget to reassign
- Proper String comparison (`.equals()` vs `==`)

---

*Remember: no grading on style — just whether your code works and shows you understand the concept. Your coding style is your own.*