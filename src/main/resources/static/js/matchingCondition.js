/** 매칭 조건 설정
 */

//나이 초기조건 설정
const inputLeft = document.getElementById("input-left");
const inputRight = document.getElementById("input-right");
const thumbLeft = document.querySelector(".slider > .thumb.left");
const thumbRight = document.querySelector(".slider > .thumb.right");
const range = document.querySelector(".slider > .range");
const [min, max] = [parseInt(inputLeft.min), parseInt(inputLeft.max)];

//거리 초기조건 설정
const inputLeft2 = document.getElementById("input-left2");
const inputRight2 = document.getElementById("input-right2");
const thumbLeft2 = document.querySelector(".slider2 > .thumb.left");
const thumbRight2 = document.querySelector(".slider2 > .thumb.right");
const range2 = document.querySelector(".slider2 > .range");
const [min2, max2] = [parseInt(inputLeft2.min), parseInt(inputLeft2.max)];

window.onload=function(){
    // 왼쪽 thumb 초기설정
    document.getElementById("ageMin").innerText = inputLeft.value;
    const percent = ((inputLeft.value - min) / (max - min)) * 100;
    thumbLeft.style.left = percent + "%";
    range.style.left = percent + "%";
    // 오른쪽 thumb 초기설정
    document.getElementById("ageMax").innerText = inputRight.value;
    const percent2 = ((inputRight.value - min) / (max - min)) * 100;
    thumbRight.style.right = 100 - percent2 + "%";
    range.style.right = 100 - percent2 + "%";
    
    document.getElementById("DXMin").innerText = inputLeft2.value + "km";
    const percent21 = ((inputLeft2.value - min2) / (max2 - min2)) * 100;
    thumbLeft2.style.left = percent21 + "%";
    range2.style.left = percent21 + "%";
    // 오른쪽 thumb 초기설정
    document.getElementById("DXMax").innerText = inputRight2.value + "km";
    const percent22 = ((inputRight2.value - min2) / (max2 - min2)) * 100;
    thumbRight2.style.right = 100 - percent22 + "%";
    range2.style.right = 100 - percent22 + "%";
    
}

const setLeftValue = () => {
const _this = inputLeft;
    const [min, max] = [parseInt(_this.min), parseInt(_this.max)];
    
    // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
    _this.value = Math.min(parseInt(_this.value), parseInt(inputRight.value) );
    
    // input, thumb 같이 움직이도록
    const percent = ((_this.value - min) / (max - min)) * 100;
    thumbLeft.style.left = percent + "%";
    range.style.left = percent + "%";
    document.getElementById("ageMin").innerText = _this.value;
};

const setRightValue = () => {
const _this = inputRight;
    const [min, max] = [parseInt(_this.min), parseInt(_this.max)];
    
    // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
    _this.value = Math.max(parseInt(_this.value), parseInt(inputLeft.value) );
    
    // input, thumb 같이 움직이도록
    const percent = ((_this.value - min) / (max - min)) * 100;
    thumbRight.style.right = 100 - percent + "%";
    range.style.right = 100 - percent + "%";
    document.getElementById("ageMax").innerText = inputRight.value;
};

inputLeft.addEventListener("input", setLeftValue);
inputRight.addEventListener("input", setRightValue);


const setLeftValue2 = () => {
const _this = inputLeft2;
    const [min, max] = [parseInt(_this.min), parseInt(_this.max)];
    
    // 교차되지 않게, 1을 빼준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
    _this.value = Math.min(parseInt(_this.value), parseInt(inputRight2.value) );
    
    // input, thumb 같이 움직이도록
    const percent = ((_this.value - min) / (max - min)) * 100;
    thumbLeft2.style.left = percent + "%";
    range2.style.left = percent + "%";
    document.getElementById("DXMin").innerText = _this.value + "km";
};

const setRightValue2 = () => {
const _this = inputRight2;
    const [min, max] = [parseInt(_this.min), parseInt(_this.max)];
    
    // 교차되지 않게, 1을 더해준 건 완전히 겹치기보다는 어느 정도 간격을 남겨두기 위해.
    _this.value = Math.max(parseInt(_this.value), parseInt(inputLeft2.value) );
    
    // input, thumb 같이 움직이도록
    const percent = ((_this.value - min) / (max - min)) * 100;
    thumbRight2.style.right = 100 - percent + "%";
    range2.style.right = 100 - percent + "%";
    document.getElementById("DXMax").innerText = inputRight2.value + "km";
};

inputLeft2.addEventListener("input", setLeftValue2);
inputRight2.addEventListener("input", setRightValue2);






