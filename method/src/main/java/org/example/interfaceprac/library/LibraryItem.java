package org.example.interfaceprac.library;

public abstract class LibraryItem implements Borrowable {
    String title;
    int ID;
    boolean isBorrowed;

    // 기본 생성자
    public LibraryItem(String title, int ID) {
        this.title = title;
        this.ID = ID;
        this.isBorrowed = false;
    }



    //빌릴수 있어?
    public void isBorrowed() {
        if(isBorrowed){
            borrowItem();
        }else {
            System.out.println("대출 불가능");
        }// if() end
    }// isBorrowed() end


    // 그럼 빌릴게
    public void borrowItem() {
        System.out.println("대출 완료");
    }// borrowItem() end

    // 아니면 안빌리게


    // 반납하기
    public void returnItem() {

    }// returnItem() end


}
