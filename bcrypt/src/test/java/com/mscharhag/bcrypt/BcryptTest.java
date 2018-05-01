package com.mscharhag.bcrypt;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {

    @Test
    public void test() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 80 character password
        String password1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String password2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        String encodedPassword1 = passwordEncoder.encode(password1);
        boolean matches = passwordEncoder.matches(password2, encodedPassword1);

        System.out.println("encodedPassword1: " + encodedPassword1);
        System.out.println("matches: " + matches);

    }


    /*
    Be aware that bcrypt has a maximum password length

bcrypt is a popular password hashing function these days.
Other than standard hash functions (like SHA-515), bcrypt is designed to be slow and therefore very resistant to brute force attacks.

However, when using bcrypt you should be aware that it limits your maximum password length to 50-72 bytes.
The exact length depends on the bcrypt implementation you are using (see http://security.stackexchange.com/questions/39849/does-bcrypt-have-a-maximum-password-length)
Passwords that exceed the maximum length will be truncated.

The following piece of code shows the password truncation using Spring Securities BCryptPasswordEncoder:

BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

// 72 characters
String password1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

// 73 characters
String password2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

String encodedPassword1 = passwordEncoder.encode(password1);
boolean matches = passwordEncoder.matches(password2, encodedPassword1);

System.out.println("encodedPassword1: " + encodedPassword1);
System.out.println("matches: " + matches);

When running this example, the output might look like this:

encodedPassword1: $2a$10$A5OpVKgjEZzmy6UNsqzkjuG2xGET1wp3b/9ET5dz/tHQ3eRvyXSSO
matches: true

According to BCryptPasswordEncoder both passwords match (= are identical) even if they have a different length.





     */
}
