SUMMARY = "Bluetooth enablement"
DESCRIPTION = "Rockchip BT enablement"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/service_file:"

SRC_URI = " \
    git://github.com/rockchip-linux/rkwifibt.git \
    file://bluetooth_rk.service \
"
SRCREV = "456b6008e495d40793eba5c8abcad8d09c65f6ea"

RDEPENDS_${PN} += "linux-firmware-rtl8723b"

S = "${WORKDIR}/git/realtek/rtk_hciattach"

TARGET_CC_ARCH += "${LDFLAGS}"

inherit systemd

SYSTEMD_SERVICE_${PN} = "bluetooth_rk.service"

do_install () {
	install -d ${D}/usr/bin
	cp -rf ${S}/rtk_hciattach ${D}/usr/bin

	install -d ${D}/lib/systemd/system
	install -m 0755 ${WORKDIR}/bluetooth_rk.service ${D}/lib/systemd/system
}
