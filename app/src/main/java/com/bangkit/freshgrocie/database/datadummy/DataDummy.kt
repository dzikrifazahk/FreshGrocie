package com.bangkit.freshgrocie.database.datadummy

import com.bangkit.freshgrocie.database.response.ResponseProductItem

class DataDummy {
    val listdummy = listOf(
        ResponseProductItem(id= "1", productName = "Sayuran", productPhoto = "https://images.unsplash.com/photo-1661956600684-97d3a4320e45?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2940&q=80"),
        ResponseProductItem(id= "2", productName = "Sayuran2", productPhoto = "https://images.unsplash.com/photo-1661956600684-97d3a4320e45?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2940&q=80"),
//        ResponseProductItem(id= "3", productName = "Sayuran3", productPhoto = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tokopedia.com%2Fjayasegarsukses%2Fsayuran-segar-serba-8000-isi-menyesuaikan-harga-pasaran-bayam%3Futm_source%3Dgoogle%26utm_medium%3Dorganic%26utm_campaign%3Dpdp-seo&psig=AOvVaw0SpYoR7e54X00tn-2kOpcr&ust=1685969819168000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCJj62JPVqf8CFQAAAAAdAAAAABAE"),
//        ResponseProductItem(id= "4", productName = "Sayuran4", productPhoto = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tokopedia.com%2Fjayasegarsukses%2Fsayuran-segar-serba-8000-isi-menyesuaikan-harga-pasaran-bayam%3Futm_source%3Dgoogle%26utm_medium%3Dorganic%26utm_campaign%3Dpdp-seo&psig=AOvVaw0SpYoR7e54X00tn-2kOpcr&ust=1685969819168000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCJj62JPVqf8CFQAAAAAdAAAAABAE"),
        )
    
    fun getDummy(): List<ResponseProductItem>{
        return listdummy
    }
}