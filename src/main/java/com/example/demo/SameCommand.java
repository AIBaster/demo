package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public interface SameCommand {
   static int getHashForCommand(String str){
       var arr = str.getBytes(StandardCharsets.UTF_8);
       int hash = 0;
       for (byte b : Arrays.copyOfRange(arr,0,4))
           hash+=b*31;
       for (byte b : Arrays.copyOfRange(arr, arr.length-5,arr.length))
           hash+=b*31;
       return hash;
   }
}
