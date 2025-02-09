package com.example.contactapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //このクラスをテーブルのデータベースとして扱う
@Table(name = "contacts") //テーブル名をcontactsに指定

public class Contact {
	
	@Id //主キー(ID)を指定。JPA（データベース管理用のライブラリ）に伝える
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDを自動生成（1,2,3...という連番）
    private Long id;
	
	@Column(nullable = false) //nullを許可しない項目として指定。データが必須であることを指定
    private String name;
	
	@Column(nullable = false)
    private String email;
	
	@Column(nullable = false, length = 1000) //messageの最大文字数を1000に制限
    private String message;
}
