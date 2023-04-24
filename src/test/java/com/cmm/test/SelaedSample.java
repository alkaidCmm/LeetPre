package com.cmm.test;

/**
 * @description:
 * @author: cmm
 * @date: 2023/4/23
 **/
public class SelaedSample {


    interface Animal{
       void run();
    }

    sealed  interface Cat extends Animal permits CatService{
    }

     sealed static class CatService implements Cat{
        @Override
        public void run(){

        }
    }

    final class SubCatService extends CatService{

    }
}
