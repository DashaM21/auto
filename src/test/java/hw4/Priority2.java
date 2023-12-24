package hw4;

import org.testng.Assert;
import org.testng.annotations.Test;

    public class Priority2 {


        @Test(priority=7)
        public void a() {
            Assert.assertTrue(true);
            System.out.println("Running test_g");
        }

        @Test(priority=6)
        public void b() {
            Assert.assertTrue(true);
            System.out.println("Running test_f");
        }

        @Test(priority=5)
        public void c() {
            Assert.assertTrue(true);
            System.out.println("Running test_e");
        }

        @Test(priority=4)
        public void d() {
            Assert.assertTrue(true);
            System.out.println("Running test_d");
        }

        @Test(priority=3)
        public void e() {
            Assert.assertTrue(true);
            System.out.println("Running test_c");
        }

        @Test(priority=2)
        public void f() {
            Assert.assertTrue(true);
            System.out.println("Running test_b");
        }

        @Test(priority=1)
        public void g() {
            Assert.assertTrue(true);
            System.out.println("Running test_a");
        }
    }