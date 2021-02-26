package com.codigo.smartstore.webapi.dto;

import com.codigo.smartstore.webapi.validators.FieldsValueMatch;

@FieldsValueMatch.List({
	@FieldsValueMatch(field = "password", fieldMatch = "verifyPassword", message = "Passwords do not match!"),
	@FieldsValueMatch(field = "email", fieldMatch = "verifyEmail", message = "Email addresses do not match!") })
public class NewUserForm {

	private String email;
	private String verifyEmail;
	private String password;
	private String verifyPassword;

	// standard constructor, getters, setters
}
//
// @PostMapping("/user")
// public String submitForm(@Valid NewUserForm newUserForm,
// BindingResult result, Model model) {
// if (result.hasErrors()) {
// return "userHome";
// }
// model.addAttribute("message", "Valid form");
// return "userHome";
// }