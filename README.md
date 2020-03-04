# Easy Dialer

## Overview
Dial numbers and determine whether they are easy or not based on incremental phoneKey adjacency.

That is, if each phoneKey is adjacent to the preceding phoneKey, the number is considered easy to dial.

### Example

```java
PhoneKey[] dialedNumber = Phone.dial("555-5555");
Phone.hangup();
return Phone.getDifficulty(dialedNumber);
```

### Usage
Phone numbers must be formatted to a proper phone number value. This includes the following patterns:

```
(555) 555-5555
555-555-5555
555-5555
```