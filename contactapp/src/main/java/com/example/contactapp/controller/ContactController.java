package com.example.contactapp.controller;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contactapp.entity.Contact;
import com.example.contactapp.service.ContactService;

@RestController //このクラスがAPIのコントローラーであることを示す。JSON形式のデータを返すAPIを作成するために必須
@RequestMapping("/contacts") //このコントローラーのAPIのURLを"/contacts"に設定
@CrossOrigin(origins = "*") // すべてのオリジンからのアクセスを許可（本番では制限するべき）

public class ContactController {
	
	private final ContactService contactService;
	
	//コンストラクタを使ってServiceを受け取る
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	//すべての問い合わせを取得するAPI（GET /contacts)
	@GetMapping
	public List<Contact> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	//新しい問い合わせを登録するAPI（POST /contacts）
	@PostMapping
	public Contact createContact(@RequestBody Contact contact) {//@RequestBodyは、リクエストのボディ（JSONデータ）を受け取る
		return contactService.createContact(contact);
	}
	
	//指定したIDの問い合わせを取得するAPI（GET /contacts/{id}）
	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable Long id) {//@PathVariableは、URLの{id}に入る値を受け取る
		return contactService.getContactById(id);
	}
	
	//指定したIDの問い合わせを更新するAPI（PUT /contacts/{id}）
	@PutMapping("/{id}")
	public Contact updateContact(@PathVariable Long id,@RequestBody Contact contact) {
		return contactService.updateContact(id, contact);
	}
	
	//指定したIDの問い合わせを削除するAPI（DELETE /contacts/{id}）
	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable Long id) {
		contactService.deleteContact(id);
	}

}
