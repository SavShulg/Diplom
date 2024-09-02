package ru.skypro.homework.bd.exception;

public class UsernameNotFoundException extends RuntimeException{

        public UsernameNotFoundException(String message, Long id) {
            super(message);
        }
    }

