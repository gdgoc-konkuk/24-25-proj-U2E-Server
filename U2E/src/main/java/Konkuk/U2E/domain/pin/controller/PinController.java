package Konkuk.U2E.domain.pin.controller;

import Konkuk.U2E.domain.news.dto.response.GetNewsInfoResponse;
import Konkuk.U2E.domain.pin.dto.response.GetPinInfoResponse;
import Konkuk.U2E.domain.pin.service.PinService;
import Konkuk.U2E.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pin")
@RequiredArgsConstructor
public class PinController {
    private final PinService pinService;

    @GetMapping("/{pinId}")
    public BaseResponse<GetPinInfoResponse> viewPinInfo(
            @PathVariable("pinId") final Long pinId
    ) {
        return BaseResponse.ok(pinService.getPinInfo(pinId));
    }
}
