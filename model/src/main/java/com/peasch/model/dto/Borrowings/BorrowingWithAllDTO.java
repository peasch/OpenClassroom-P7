package com.peasch.model.dto.Borrowings;

import com.peasch.model.dto.User.UserDto;
import com.peasch.model.dto.copies.CopyDto;
import com.peasch.model.dto.copies.CopyWithALLDTO;

public class BorrowingWithAllDTO extends BorrowingDto {

    private CopyWithALLDTO copy;
    private Integer daysToGo;

    public BorrowingWithAllDTO() {
    }

    public CopyWithALLDTO getCopy() {
        return copy;
    }

    public void setCopy(CopyWithALLDTO copy) {
        this.copy = copy;
    }

    public Integer getDaysToGo() {
        return daysToGo;
    }

    public void setDaysToGo(Integer daysToGo) {
        this.daysToGo = daysToGo;
    }
}
