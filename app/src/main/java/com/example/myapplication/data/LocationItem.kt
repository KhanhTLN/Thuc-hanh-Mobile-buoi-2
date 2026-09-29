package com.example.myapplication.data

import java.io.Serializable

data class LocationItem(
    val name: String,
    val description: String,
    val imageUrl: String,
    val address: String
) : Serializable

object HanoiLocations {
    fun getLocations(): ArrayList<LocationItem> {
        val list = ArrayList<LocationItem>()
        list.add(
            LocationItem(
                name = "Hồ Hoàn Kiếm",
                description = "Hồ Hoàn Kiếm (Hồ Gươm) là trái tim của Thủ đô Hà Nội, gắn liền với truyền thuyết vua Lê Lợi trả gươm thần cho Rùa Vàng. Nơi đây có Tháp Rùa, cầu Thê Húc và đền Ngọc Sơn cổ kính.",
                imageUrl = "https://ik.imgkit.net/tvlk/blog/2022/08/ho-guom-17.jpg",
                address = "Hoàn Kiếm, Hà Nội"
            )
        )
        list.add(
            LocationItem(
                name = "Văn Miếu - Quốc Tử Giám",
                description = "Quần thể di tích Văn Miếu - Quốc Tử Giám là trường đại học đầu tiên của Việt Nam, nơi tôn vinh Nho học và lưu giữ các bia tiến sĩ triều Lê - Mạc.",
                imageUrl = "https://image.vietgoing.com/destination/large/vietgoing_epf2301122793.webp",
                address = "Đống Đa, Hà Nội"
            )
        )
        list.add(
            LocationItem(
                name = "Lăng Chủ tịch Hồ Chí Minh",
                description = "Lăng Bác là nơi lưu giữ thi hài của Chủ tịch Hồ Chí Minh. Quảng trường Ba Đình lịch sử trước lăng là nơi Người đọc bản Tuyên ngôn Độc lập.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmoiyIIJnKERhIyTRZQLHTdCXrOxtDasrsOGMImag34FoQFKA7_Y3j8oMj&s=10",
                address = "Ba Đình, Hà Nội"
            )
        )
        list.add(
            LocationItem(
                name = "Chùa Một Cột",
                description = "Chùa Một Cột (Diên Hựu tự) có kiến trúc độc đáo hình bông sen nở trên cột đá giữa hồ, biểu tượng văn hóa nghìn năm của Thăng Long - Hà Nội.",
                imageUrl = "https://dingdangvietnam.com/cdn/shop/articles/Thi_t_k_ch_a_co_ten_68a7c6fe-1277-44be-901f-b881b028e11c.png?v=1730272259",
                address = "Ba Đình, Hà Nội"
            )
        )
        list.add(
            LocationItem(
                name = "Hồ Tây",
                description = "Hồ Tây là hồ tự nhiên lớn nhất nội thành Hà Nội, nổi tiếng với phong cảnh nên thơ, hoàng hôn tuyệt đẹp và các ngôi cổ tự như chùa Trấn Quốc.",
                imageUrl = "https://static.vinwonders.com/production/ho-tay-o-dau-2.jpg",
                address = "Tây Hồ, Hà Nội"
            )
        )
        list.add(
            LocationItem(
                name = "Hoàng thành Thăng Long",
                description = "Di sản văn hóa thế giới với bề dày lịch sử hơn một nghìn năm, là trung tâm quyền lực của các triều đại phong kiến Việt Nam.",
                imageUrl = "https://tonkinboutiquehotel.com/UploadFile/Blog/anh1%20ho%C3%A0ng%20th%C3%A0nh.jpg",
                address = "Ba Đình, Hà Nội"
            )
        )
        list.add(
            LocationItem(
                name = "Cầu Long Biên",
                description = "Cầu thép lịch sử bắc qua sông Hồng do Pháp xây dựng cuối thế kỷ 19, chứng nhân lịch sử qua hai cuộc kháng chiến chống Pháp và chống Mỹ.",
                imageUrl = "https://imghappyvietnam.vnanet.vn/MediaUpload/Org/2025/10/08/114002-vna_potal_cau_long_bien_-_bieu_tuong_van_hoa_lich_su_cua_ha_noi_7831269-1.jpeg",
                address = "Long Biên, Hà Nội"
            )
        )
        return list
    }
}

object DanangLocations {
    fun getLocations(): ArrayList<LocationItem> {
        val list = ArrayList<LocationItem>()
        list.add(
            LocationItem(
                name = "Cầu Rồng Đà Nẵng",
                description = "Cầu Rồng bắc qua sông Hàn với kiến trúc độc đáo mô phỏng hình con rồng có khả năng phun lửa và phun nước vào cuối tuần.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5Xtzgf3nO2XnzX7dKPauOA6qTQoU1pCk89w3Jodh1_0R7QLeMgTiIAyk&s=10",
                address = "Hải Châu, Đà Nẵng"
            )
        )
        list.add(
            LocationItem(
                name = "Bà Nà Hills",
                description = "Khu du lịch nổi tiếng với Cầu Vàng (Golden Bridge) độc đáo được nâng đỡ bởi đôi bàn tay khổng lồ và khí hậu mát mẻ quanh năm.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_bRhnlmff7BcaLX3-zOUYmEHRowQ-brrzJruf785VoFhF_q5i6mMaKTzy&s=10",
                address = "Hòa Vang, Đà Nẵng"
            )
        )
        list.add(
            LocationItem(
                name = "Ngũ Hành Sơn",
                description = "Quần thể gồm 5 ngọn núi đá vôi với hệ thống hang động kỳ bí, các ngôi cổ tự cổ kính và làng nghề đá mỹ nghệ Non Nước.",
                imageUrl = "https://thiennhienmoitruong.vn/upload/images/btv/btv5/kinh-nghiem-tham-quan-ngu-hanh-son-cho-du-khach-du-lich-da-nang.jpg",
                address = "Ngũ Hành Sơn, Đà Nẵng"
            )
        )
        list.add(
            LocationItem(
                name = "Chùa Linh Ứng Bãi Bụt",
                description = "Ngôi chùa lớn và linh thiêng nhất Đà Nẵng trên bán đảo Sơn Trà, nổi tiếng với bức tượng Phật Quan Thế Âm cao nhất Việt Nam hướng nhìn ra biển.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP76TurBPM2zc4kIMau_uKI0hWU6lSf3RZCtKDEeM6TqgqWYW3S_YzdtGW&s=10",
                address = "Sơn Trà, Đà Nẵng"
            )
        )
        list.add(
            LocationItem(
                name = "Bãi biển Mỹ Khê",
                description = "Một trong những bãi biển quyến rũ nhất hành tinh với bờ cát trắng mịn, làn nước trong xanh và sóng biển ôn hòa.",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIkL1yUS8It8sw6xdBJ3Mm4vxidYvSBmlZoh2BIEX_Oc_WO7YHHXytc4Q&s=10",
                address = "Sơn Trà & Ngũ Hành Sơn, Đà Nẵng"
            )
        )
        list.add(
            LocationItem(
                name = "Bán đảo Sơn Trà",
                description = "Được mệnh danh là 'lá phổi xanh' của Đà Nẵng, nơi sinh sống của loài Voọc chà vá chân nâu quý hiếm cùng nhiều cảnh quan thiên nhiên hoang sơ.",
                imageUrl = "https://giant.vn/wp-content/uploads/2024/05/bandao.jpg",
                address = "Sơn Trà, Đà Nẵng"
            )
        )
        list.add(
            LocationItem(
                name = "Cầu Tình Yêu & Tượng Cá Chép Hóa Rồng",
                description = "Điểm hẹn lãng mạn bên sông Hàn với hàng ngàn ổ khóa tình yêu và biểu tượng tượng đá nghệ thuật độc đáo.",
                imageUrl = "https://statics.vinpearl.com/cau-tinh-yeu-da-nang-1_1629472108.jpg",
                address = "Hải Châu, Đà Nẵng"
            )
        )
        return list
    }
}
