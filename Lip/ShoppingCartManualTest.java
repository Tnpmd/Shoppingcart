package Lip;

import java.util.ArrayList;

public class ShoppingCartManualTest {
    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
        //Test 4 : คำนวณ 1 แถม 1
        ArrayList<CartItem> BogoCart = new ArrayList<>();
        BogoCart.add(new CartItem("BOGO","Nutella Eclair",29.0,2));
        BogoCart.add(new CartItem("BOGO","Chocolate",30.0,3));
        double total4 = ShoppingCartCalculator.calculateTotalPrice(BogoCart);
        if (total4 == 89.0) {
            System.out.println("PASSED: BogoCart cart total is correct (89.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BogoCart cart total expected 89.0 but got " + total4);
            failedCount++;
        }

        //Test 5 : คำนวณโปรโมชั่นซื้อ6ชิ้นขึ้นไปลด10%
        ArrayList<CartItem> BulkCart = new ArrayList<>();
        BulkCart.add(new CartItem("BULK","Iced matcha latte",45.0,2));
        BulkCart.add(new CartItem("BULK","Signature toffy coconut",50.0,1));
        BulkCart.add(new CartItem("BULK","Fresh milk",40.0,3));
        double total5 = ShoppingCartCalculator.calculateTotalPrice(BulkCart);
        if (total5 == 234.0) {
            System.out.println("PASSED: BulkCart cart total is correct (234.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BulkCart cart total expected 234.0 but got " + total5);
            failedCount++;
        }

        //Test 6 : รวมสินค้าทั้งหมด
        ArrayList<CartItem> Cart = new ArrayList<>();
        Cart.add(new CartItem("BULK","Iced matcha latte",45.0,2));
        Cart.add(new CartItem("BULK","Signature toffy coconut",50.0,1));
        Cart.add(new CartItem("BULK","Fresh milk",40.0,3));
        Cart.add(new CartItem("BOGO","Nutella Eclair",29.0,2));
        Cart.add(new CartItem("BOGO","Chocolate",30.0,3));
        Cart.add(new CartItem("NORMAL", "Bread", 25.0, 2));
        Cart.add(new CartItem("NORMAL", "Milk", 15.0, 1)); 
        double total6 = ShoppingCartCalculator.calculateTotalPrice(Cart);
        if (total6 == 388.0) {
            System.out.println("PASSED: BulkCart cart total is correct (388.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BulkCart cart total expected 388.0 but got " + total6);
            failedCount++;
        }

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
