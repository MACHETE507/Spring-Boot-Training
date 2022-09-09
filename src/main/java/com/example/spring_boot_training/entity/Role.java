package com.example.spring_boot_training.entity;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ADMIN(Right.TODO_CREATE, Right.TODO_READ, Right.TODO_READ_ALL, Right.TODO_UPDATE, Right.TODO_DELETE),
    USER(Right.TODO_READ, Right.TODO_READ_ALL, Right.TODO_CREATE, Right.TODO_UPDATE),

    MANAGER(Right.TODO_READ, Right.TODO_READ_ALL, Right.TODO_DELETE),
    ANALYST(Right.TODO_READ, Right.TODO_READ_ALL);

    private List<Right> rights;

    public List<Right>getRights() {
        return this.rights;
    }

    Role(Right... right) {
        this.rights = Arrays.asList(right);
    }
    //** später umbauen **/
//    ADMIN(Right.READ, Right.READ_ALL, Right.CREATE, Right.DELETE, Right.UPDATE),
//    USER(Right.READ, Right.READ_ALL, Right.CREATE, Right.UPDATE),
//    ANALYST(Right.READ, Right.READ_ALL);
//
//    private List<Right> rechte;
//
//    public  List<Right> getRechte(){
//        return this.rechte;
//    }
//
//    Role(Right... recht){
//        this.rechte = Arrays.asList(recht);
//    }

}
