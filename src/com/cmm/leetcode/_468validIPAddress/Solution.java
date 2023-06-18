package com.cmm.leetcode._468validIPAddress;

class Solution {
    public String validIPAddress(String queryIP) {
        String[] ipv4 = queryIP.split("\\.");
        String[] ipv6 = queryIP.split("\\:");
        if (queryIP.chars().filter(c -> c == '.').count() == 3) {
            for (String s : ipv4) {
                if (ipv4(s)) {
                    continue;
                } else {
                    return "Neither";
                }
            }

            return "IPv4";
        }
        if (queryIP.chars().filter(c -> c == ':').count() == 7) {
            for (String s : ipv6) {
                if (ipv6(s)) {
                    continue;
                } else {
                    return "Neither";
                }
            }

            return "IPv6";
        }

        return "Neither";
    }

    public boolean ipv4(String s) {
        try {
            return String.valueOf(Integer.parseInt(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean ipv6(String s) {
        if (s.length() > 4) {
            return false;
        }

        try {
            //  && s.charAt(0) != '-';
            return Integer.parseInt(s, 16) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Solution().validIPAddress("1.0.1.");
    }
}
