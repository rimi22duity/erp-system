package maks.erp.system.service;

import maks.erp.system.enums.LeaveType;
import maks.erp.system.model.LeaveInfo;
import maks.erp.system.dto.LeaveInfoDto;
import maks.erp.system.repository.LeaveInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveApplicationService {

    @Autowired
    private LeaveInfoRepository leaveInfoRepository;
    public void addLeaveApplication(LeaveInfoDto leaveInfoDto) {
        LeaveInfo leaveInfo = LeaveInfo.builder()
                .leaveType(leaveInfoDto.getLeaveType())
                .description(leaveInfoDto.getDescription())
                .fromDate(leaveInfoDto.getFromDate())
                .toDate(leaveInfoDto.getToDate())
                .build();

        leaveInfoRepository.save(leaveInfo);
    }

    public List<String> getLeaveTypes() {
        return LeaveType.getLeaveTypeList();
    }
}
