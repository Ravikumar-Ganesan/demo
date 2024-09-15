package com.example.demo.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseStringTest {

  @Test
  void reverse() {
    assertEquals("cba", ReverseString.reverse("abc"));
    assertEquals("54321", ReverseString.reverse("12345"));
    assertEquals("", ReverseString.reverse(""));
    assertEquals("a", ReverseString.reverse("a"));
//    assertNull(ReverseString.reverse(null));
  }

  @Test
  void reverse2() {
    assertEquals("cba", ReverseString.reverse2("abc"));
    assertEquals("54321", ReverseString.reverse2("12345"));
    assertEquals("", ReverseString.reverse2(""));
    assertEquals("a", ReverseString.reverse2("a"));
    assertNull(ReverseString.reverse2(null));
  }
}