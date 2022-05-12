package com.example.hrmsbackend.core.utilities.helpers.email;

import com.example.hrmsbackend.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String body);
}
