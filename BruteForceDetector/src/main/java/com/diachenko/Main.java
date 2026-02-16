package com.diachenko;


/*  Codewars Project
    16.02.2026
    @author DiachenkoDanylo
*/

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //
//            You're analyzing authentication logs. Each log entry is a string like:
//
//            192.168.1.1 LOGIN_FAIL user=admin
//            192.168.1.1 LOGIN_SUCCESS user=admin
//            10.0.0.5 LOGIN_FAIL user=root
//            An IP is suspicious if it has 3 or more consecutive failures without a success in between. Return a list of suspicious IPs, sorted alphabetically.
//
//            logs = [
//            "192.168.1.1 LOGIN_FAIL user=admin",
//            "192.168.1.1 LOGIN_FAIL user=admin",
//            "192.168.1.1 LOGIN_FAIL user=root",
//            "10.0.0.5 LOGIN_FAIL user=test",
//            "10.0.0.5 LOGIN_SUCCESS user=test"
//            ]
//    detect_brute_force(logs)  # ["192.168.1.1"]


    public static void main(String[] args) {
        String[] logs = new String[]{
                "192.168.1.1 LOGIN_FAIL user=admin",
                "192.168.1.1 LOGIN_FAIL user=admin",
                "192.168.1.1 LOGIN_FAIL user=root",
                "10.0.0.5 LOGIN_FAIL user=test",
                "10.0.0.5 LOGIN_SUCCESS user=test"
        };
        System.out.println(detectBruteForce(logs));
    }


//    COncurrent
//    public static List<String> detectBruteForce(String[] logs) {
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//        for (String log : logs) {
//            String address = log.substring(0, log.indexOf("LOGIN")-1);
//            if (map.containsKey(address)) {
//                if (log.contains("SUCCESS")) {
//                    map.put(address, 0);
//                } else if (log.contains("FAIL")) {
//                    map.computeIfPresent(address, (k, v) -> v + 1);
//                }
//            } else {
//                map.putIfAbsent(address, 1);
//            }
//        }
//        return map.entrySet().parallelStream().filter(x->x.getValue()>3).map(entry -> entry.getKey()).sorted().collect(Collectors.toList());
//    }

    //bad behavior
//    public static List<String> detectBruteForce(String[] logs) {
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String log : logs) {
//            String address = log.substring(0, log.indexOf("LOGIN") - 1);
//            if (log.contains("FAIL")) {
//                map.merge(address, 1, Integer::sum);
//            } else if (log.contains("SUCCESS")) {
//                map.merge(address, 0, (oldVal, newVal) -> 0);
//            }
//        }
//            return map.entrySet().stream().filter(x -> x.getValue() >= 3).map(Map.Entry::getKey).sorted()
//                .collect(Collectors.toList());
//    }
//
    // latest version
    public static List<String> detectBruteForce(String[] logs) {
        Map<String, Integer> counts = new HashMap<>();
        Set<String> suspicious = new HashSet<>();

        for (String log : logs) {
            String address = log.substring(0, log.indexOf("LOGIN") - 1);
            if (log.contains("LOGIN_FAIL")) {
                counts.merge(address, 1, Integer::sum);
                if (counts.get(address) >= 3) {
                    suspicious.add(address);
                }
            } else if (log.contains("LOGIN_SUCCESS")) {
                counts.put(address, 0);
            }
        }

        return suspicious.stream().sorted().collect(Collectors.toList());
    }
}