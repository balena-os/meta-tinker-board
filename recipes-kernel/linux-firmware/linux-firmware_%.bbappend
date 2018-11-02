PACKAGES =+ "${PN}-rtl8723b"

do_install_append () {
    install -d ${D}/lib/firmware/rtlbt
    mv ${D}/lib/firmware/rtl_bt/rtl8723b_fw.bin ${D}/lib/firmware/rtlbt/rtl8723b_fw
    mv ${D}/lib/firmware/rtl_bt/rtl8723d_config.bin ${D}/lib/firmware/rtlbt/rtl8723d_config
}

FILES_${PN}-rtl8723b = " \
    /lib/firmware/rtlbt/rtl8723b_fw \
    /lib/firmware/rtlbt/rtl8723d_config \
"
