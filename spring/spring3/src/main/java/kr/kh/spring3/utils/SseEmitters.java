package kr.kh.spring3.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitters {

	private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

	public SseEmitter add(String id, SseEmitter emitter) {
		this.emitters.put(id, emitter);

		emitter.onCompletion(() -> {
			this.emitters.remove(id); // 만료되면 리스트에서 삭제
		});
		emitter.onTimeout(() -> {
			emitter.complete();
		});

		return emitter;
	}

	public SseEmitter get(String to) {
		return emitters.get(to);
	}
}
