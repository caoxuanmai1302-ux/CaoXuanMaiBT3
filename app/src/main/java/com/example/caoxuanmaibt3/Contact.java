package com.example.caoxuanmaibt3;

public class Contact {
        private int id;
        private String name;
        private String phoneNumber;

        // Constructor mặc định (rất quan trọng)
        public Contact() {
        }

        // Constructor có tham số
        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        // Constructor đầy đủ
        public Contact(int id, String name, String phoneNumber) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        // Getter và Setter
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

}
