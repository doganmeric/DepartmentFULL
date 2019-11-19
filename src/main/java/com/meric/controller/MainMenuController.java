package com.meric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainMenuController {
	@RequestMapping("/")
	public String mainMenu() {
		
		return "main-menu";
	}
	/*
 - Görsel tasarım = 10 
t- Ekran geçişleri = 10
t- İki ekranda departman ismi görüntüleme ve insert/update (combolar çalışmasa bile bu alan çalışmalı) = 10
t- Radyo buton ile kayıt seçimi = 10
t- Onay sorusu ile silme işlemi = 10
t- Üç alan üzerinden sorgu, comboboxlar sorguda ve kayıtta boş geçilebilmeli = 15
t- Manager ve Location alanlarının combobox olması, search ve kaydetme işlemleri = 15
t- Department name kaydette zorunlu olması(hibernate validation) = 10
t- Department name minimum uzunluk 2 hane olması(hibernate validation) = 10
t- Department name UK kontrolü, hata alırsa uygun hata mesajı = 10
- Seçilen manager bir başka departmanın yöneticisi ise validasyon diğer departman adını belirterek izin vermesin. 
("Bu manager x departmanının yöneticisi, kaydedilmedi") (custom validation) = 10
	 */
}
