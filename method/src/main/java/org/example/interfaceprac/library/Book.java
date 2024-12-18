package org.example.interfaceprac.library;

public class Book extends LibraryPhysicalItem {
    public Book(String title, int ID, String location) {
        super(title, ID, location);
    }

    @Override
    void findLocation() {

    }

//    @Override
//    public void isBorrowed() {
//
//    }

//
//    @Override
//    //빌릴수 있어?
//    public void isBorrowed() {
//        if (isBorrowed) {
//            borrowItem();
//        } else {
//            System.out.println("대출 불가능");
//        }// if() end
//    }// isBorrowed() end
//
//    @Override
//    // 그럼 빌릴게
//    public void borrowItem() {
//        System.out.println("대출 완료");
//    }// borrowItem() end
//
//    // 아니면 안빌리게
//
//    @Override
//    // 반납하기
//    public void returnItem() {
//
//    }// returnItem() end

}
