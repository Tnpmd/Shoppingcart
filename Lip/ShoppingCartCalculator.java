package Lip;

import java.util.ArrayList;

public class ShoppingCartCalculator {
    /**
     * เป็นเมธอดคำนวณราคาสุทธิของสินค้าในตะกร้าประกอบไปด้วยราคารวมพื้นฐาน(มีรหัสการซื้อเป็น "Normal"),
     * ราคาโปรโมชั่น1แถม1(มีรหัสการซื้อเป็น "BOGO"),
     * ซื้อ6ชิ้นขึ้นไปได้ราคาส่วนลด10%(มีรหัสการซื้อเป็น "BULK")
     * @param sku คือ string ของรหัสสินค้า(BOGO,NORMOL,BULK)
     * @param name คือ string ของชื่อสินค้า
     * @param price คือ double ของราคาต่อชิ้น (ต้องไม่ติดลบ)
     * @param quantity คือ int ของจำนวนที่ซื้อ (ต้องไม่ติดลบ)
     * @return ราคาสุทธิของสินค้าในตะกร้าและรีเทิร์น0.0เมื่อตะกร้าเป็นnull/ตะกร้าว่าง
     * @throws IllegalArgumentException เมื่อจำนวน/ราคาสินค้าติดลบ
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double total = 0.0;
        int quantityBulk = 0; 
        if (items == null || items.isEmpty()) {return 0.0;}
        for (CartItem item : items) {
             if ("BULK".equals(item.sku())) {
                quantityBulk += item.quantity();
            }
        }
        for (CartItem item : items) {
            if (item.price() < 0) throw new IllegalArgumentException("Price must not be negative");
            if (item.quantity() < 0) throw new IllegalArgumentException("Quantity must not be negative");
            
            switch (item.sku()) {
                case "BOGO" : { 
                    int quantityItem = (item.quantity() + 1)/2;
                    total += item.price()*quantityItem;
                }
                    break;
                case "BULK" : { 
                    if (quantityBulk >= 6) {
                        total += item.price()*item.quantity()*0.9;
                    }else
                        total += item.price()*item.quantity();
                    break;
                }
                default :
                    total += item.price()*item.quantity();
                    break;
                }
            }
        return total;
    }
}

