package com.cn.rx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utilities for dealing with MIME types.
 * Used to implement java.net.URLConnection and android.webkit.MimeTypeMap.
 */
public final class MimeUtils {

    private static final Map<String, String> mimeTypeToExtensionMap = new LinkedHashMap<>();
    private static final Map<String, String> extensionToMimeTypeMap = new LinkedHashMap<>();

    private MimeUtils() {
    }

    static {
        add("application/andrew-inset", "ez");
        add("application/dsptype", "tsp");
        add("application/futuresplash", "spl");
        add("application/hta", "hta");
        add("application/mac-binhex40", "hqx");
        add("application/mac-compactpro", "cpt");
        add("application/mathematica", "nb");
        add("application/msaccess", "mdb");
        add("application/oda", "oda");
        add("application/ogg", "ogg");
        add("application/pdf", "pdf");
        add("application/pgp-keys", "key");
        add("application/pgp-signature", "pgp");
        add("application/pics-rules", "prf");
        add("application/rar", "rar");
        add("application/rdf+xml", "rdf");
        add("application/rss+xml", "rss");
        add("application/zip", "zip");
        add("application/vnd.android.package-archive", "apk");
        add("application/vnd.cinderella", "cdy");
        add("application/vnd.ms-pki.stl", "stl");
        add("application/vnd.oasis.opendocument.database", "odb");
        add("application/vnd.oasis.opendocument.formula", "odf");
        add("application/vnd.oasis.opendocument.graphics", "odg");
        add("application/vnd.oasis.opendocument.graphics-template", "otg");
        add("application/vnd.oasis.opendocument.image", "odi");
        add("application/vnd.oasis.opendocument.spreadsheet", "ods");
        add("application/vnd.oasis.opendocument.spreadsheet-template", "ots");
        add("application/vnd.oasis.opendocument.text", "odt");
        add("application/vnd.oasis.opendocument.text-master", "odm");
        add("application/vnd.oasis.opendocument.text-template", "ott");
        add("application/vnd.oasis.opendocument.text-web", "oth");
        add("application/vnd.google-earth.kml+xml", "kml");
        add("application/vnd.google-earth.kmz", "kmz");
        add("application/msword", "doc");
        add("application/msword", "dot");
        add("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        add("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx");
        add("application/vnd.ms-excel", "xls");
        add("application/vnd.ms-excel", "xlt");
        add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        add("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx");
        add("application/vnd.ms-powerpoint", "ppt");
        add("application/vnd.ms-powerpoint", "pot");
        add("application/vnd.ms-powerpoint", "pps");
        add("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        add("application/vnd.openxmlformats-officedocument.presentationml.template", "potx");
        add("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx");
        add("application/vnd.rim.cod", "cod");
        add("application/vnd.smaf", "mmf");
        add("application/vnd.stardivision.calc", "sdc");
        add("application/vnd.stardivision.draw", "sda");
        add("application/vnd.stardivision.impress", "sdd");
        add("application/vnd.stardivision.impress", "sdp");
        add("application/vnd.stardivision.math", "smf");
        add("application/vnd.stardivision.writer", "sdw");
        add("application/vnd.stardivision.writer", "vor");
        add("application/vnd.stardivision.writer-global", "sgl");
        add("application/vnd.sun.xml.calc", "sxc");
        add("application/vnd.sun.xml.calc.template", "stc");
        add("application/vnd.sun.xml.draw", "sxd");
        add("application/vnd.sun.xml.draw.template", "std");
        add("application/vnd.sun.xml.impress", "sxi");
        add("application/vnd.sun.xml.impress.template", "sti");
        add("application/vnd.sun.xml.math", "sxm");
        add("application/vnd.sun.xml.writer", "sxw");
        add("application/vnd.sun.xml.writer.global", "sxg");
        add("application/vnd.sun.xml.writer.template", "stw");
        add("application/vnd.visio", "vsd");
        add("application/x-abiword", "abw");
        add("application/x-apple-diskimage", "dmg");
        add("application/x-bcpio", "bcpio");
        add("application/x-bittorrent", "torrent");
        add("application/x-cdf", "cdf");
        add("application/x-cdlink", "vcd");
        add("application/x-chess-pgn", "pgn");
        add("application/x-cpio", "cpio");
        add("application/x-debian-package", "deb");
        add("application/x-debian-package", "udeb");
        add("application/x-director", "dcr");
        add("application/x-director", "dir");
        add("application/x-director", "dxr");
        add("application/x-dms", "dms");
        add("application/x-doom", "wad");
        add("application/x-dvi", "dvi");
        add("application/x-flac", "flac");
        add("application/x-font", "pfa");
        add("application/x-font", "pfb");
        add("application/x-font", "gsf");
        add("application/x-font", "pcf");
        add("application/x-font", "pcf.Z");
        add("application/x-freemind", "mm");
        add("application/x-gnumeric", "gnumeric");
        add("application/x-go-sgf", "sgf");
        add("application/x-graphing-calculator", "gcf");
        add("application/x-gtar", "gtar");
        add("application/x-gtar", "tgz");
        add("application/x-gtar", "taz");
        add("application/x-hdf", "hdf");
        add("application/x-ica", "ica");
        add("application/x-internet-signup", "ins");
        add("application/x-internet-signup", "isp");
        add("application/x-iphone", "iii");
        add("application/x-iso9660-image", "iso");
        add("application/x-jmol", "jmz");
        add("application/x-kchart", "chrt");
        add("application/x-killustrator", "kil");
        add("application/x-koan", "skp");
        add("application/x-koan", "skd");
        add("application/x-koan", "skt");
        add("application/x-koan", "skm");
        add("application/x-kpresenter", "kpr");
        add("application/x-kpresenter", "kpt");
        add("application/x-kspread", "ksp");
        add("application/x-kword", "kwd");
        add("application/x-kword", "kwt");
        add("application/x-latex", "latex");
        add("application/x-lha", "lha");
        add("application/x-lzh", "lzh");
        add("application/x-lzx", "lzx");
        add("application/x-maker", "frm");
        add("application/x-maker", "maker");
        add("application/x-maker", "frame");
        add("application/x-maker", "fb");
        add("application/x-maker", "book");
        add("application/x-maker", "fbdoc");
        add("application/x-mif", "mif");
        add("application/x-ms-wmd", "wmd");
        add("application/x-ms-wmz", "wmz");
        add("application/x-msi", "msi");
        add("application/x-ns-proxy-autoconfig", "pac");
        add("application/x-nwc", "nwc");
        add("application/x-object", "o");
        add("application/x-oz-application", "oza");
        add("application/x-pkcs12", "p12");
        add("application/x-pkcs7-certreqresp", "p7r");
        add("application/x-pkcs7-crl", "crl");
        add("application/x-quicktimeplayer", "qtl");
        add("application/x-shar", "shar");
        add("application/x-shockwave-flash", "swf");
        add("application/x-stuffit", "sit");
        add("application/x-sv4cpio", "sv4cpio");
        add("application/x-sv4crc", "sv4crc");
        add("application/x-tar", "tar");
        add("application/x-texinfo", "texinfo");
        add("application/x-texinfo", "texi");
        add("application/x-troff", "t");
        add("application/x-troff", "roff");
        add("application/x-troff-man", "man");
        add("application/x-ustar", "ustar");
        add("application/x-wais-source", "src");
        add("application/x-wingz", "wz");
        add("application/x-webarchive", "webarchive");
        add("application/x-webarchive-xml", "webarchivexml");
        add("application/x-x509-ca-cert", "crt");
        add("application/x-xcf", "xcf");
        add("application/x-xfig", "fig");
        add("application/xhtml+xml", "xhtml");
        add("audio/3gpp", "3gpp");
        add("audio/amr", "amr");
        add("audio/basic", "snd");
        add("audio/midi", "mid");
        add("audio/midi", "midi");
        add("audio/midi", "kar");
        add("audio/midi", "xmf");
        add("audio/mobile-xmf", "mxmf");
        add("audio/mpeg", "mpga");
        add("audio/mpeg", "mpega");
        add("audio/mpeg", "mp2");
        add("audio/mpeg", "mp3");
        add("audio/mpeg", "m4a");
        add("audio/mpegurl", "m3u");
        add("audio/prs.sid", "sid");
        add("audio/x-aiff", "aif");
        add("audio/x-aiff", "aiff");
        add("audio/x-aiff", "aifc");
        add("audio/x-gsm", "gsm");
        add("audio/x-ms-wma", "wma");
        add("audio/x-ms-wax", "wax");
        add("audio/x-pn-realaudio", "ra");
        add("audio/x-pn-realaudio", "rm");
        add("audio/x-pn-realaudio", "ram");
        add("audio/x-scpls", "pls");
        add("audio/x-sd2", "sd2");
        add("audio/x-wav", "wav");
        add("image/bmp", "bmp");
        add("audio/x-qcp", "qcp");
        add("image/gif", "gif");
        add("image/ico", "cur");
        add("image/ico", "ico");
        add("image/ief", "ief");
        add("image/jpeg", "jpeg");
        add("image/jpeg", "jpg");
        add("image/jpeg", "jpe");
        add("image/pcx", "pcx");
        add("image/png", "png");
        add("image/svg+xml", "svg");
        add("image/svg+xml", "svgz");
        add("image/tiff", "tiff");
        add("image/tiff", "tif");
        add("image/vnd.djvu", "djvu");
        add("image/vnd.djvu", "djv");
        add("image/vnd.wap.wbmp", "wbmp");
        add("image/x-cmu-raster", "ras");
        add("image/x-coreldraw", "cdr");
        add("image/x-coreldrawpattern", "pat");
        add("image/x-coreldrawtemplate", "cdt");
        add("image/x-jg", "art");
        add("image/x-jng", "jng");
        add("image/x-photoshop", "psd");
        add("image/x-portable-anymap", "pnm");
        add("image/x-portable-bitmap", "pbm");
        add("image/x-portable-graymap", "pgm");
        add("image/x-portable-pixmap", "ppm");
        add("image/x-rgb", "rgb");
        add("image/x-xbitmap", "xbm");
        add("image/x-xpixmap", "xpm");
        add("image/x-xwindowdump", "xwd");
        add("model/iges", "igs");
        add("model/iges", "iges");
        add("model/mesh", "msh");
        add("model/mesh", "mesh");
        add("model/mesh", "silo");
        add("text/calendar", "ics");
        add("text/calendar", "icz");
        add("text/comma-separated-values", "csv");
        add("text/css", "css");
        add("text/html", "htm");
        add("text/html", "html");
        add("text/h323", "323");
        add("text/iuls", "uls");
        add("text/mathml", "mml");
        add("text/plain", "txt");
        add("text/plain", "log");
        add("text/plain", "asc");
        add("text/plain", "text");
        add("text/plain", "diff");
        add("text/plain", "po");
        add("text/richtext", "rtx");
        add("text/rtf", "rtf");
        add("text/texmacs", "ts");
        add("text/text", "phps");
        add("text/tab-separated-values", "tsv");
        add("text/xml", "xml");
        add("text/x-bibtex", "bib");
        add("text/x-boo", "boo");
        add("text/x-c++hdr", "h++");
        add("text/x-c++hdr", "hpp");
        add("text/x-c++hdr", "hxx");
        add("text/x-c++hdr", "hh");
        add("text/x-c++src", "c++");
        add("text/x-c++src", "cpp");
        add("text/x-c++src", "cxx");
        add("text/x-chdr", "h");
        add("text/x-component", "htc");
        add("text/x-csh", "csh");
        add("text/x-csrc", "c");
        add("text/x-dsrc", "d");
        add("text/x-haskell", "hs");
        add("text/x-java", "java");
        add("text/x-literate-haskell", "lhs");
        add("text/x-moc", "moc");
        add("text/x-pascal", "p");
        add("text/x-pascal", "pas");
        add("text/x-pcs-gcd", "gcd");
        add("text/x-setext", "etx");
        add("text/x-tcl", "tcl");
        add("text/x-tex", "tex");
        add("text/x-tex", "ltx");
        add("text/x-tex", "sty");
        add("text/x-tex", "cls");
        add("text/x-vcalendar", "vcs");
        add("text/x-vcard", "vcf");
        add("video/3gpp", "3gp");
        add("video/3gpp", "3g2");
        add("video/dl", "dl");
        add("video/dv", "dif");
        add("video/dv", "dv");
        add("video/fli", "fli");
        add("video/m4v", "m4v");
        add("video/mpeg", "mpeg");
        add("video/mpeg", "mpg");
        add("video/mpeg", "mpe");
        add("video/mp4", "mp4");
        add("video/mpeg", "VOB");
        add("video/quicktime", "qt");
        add("video/quicktime", "mov");
        add("video/vnd.mpegurl", "mxu");
        add("video/webm", "webm");
        add("video/x-la-asf", "lsf");
        add("video/x-la-asf", "lsx");
        add("video/x-mng", "mng");
        add("video/x-ms-asf", "asf");
        add("video/x-ms-asf", "asx");
        add("video/x-ms-wm", "wm");
        add("video/x-ms-wmv", "wmv");
        add("video/x-ms-wmx", "wmx");
        add("video/x-ms-wvx", "wvx");
        add("video/x-msvideo", "avi");
        add("video/x-sgi-movie", "movie");
        add("x-conference/x-cooltalk", "ice");
        add("x-epoc/x-sisx-app", "sisx");
        add("application/x-dbx", "dbx");
        add("application/vnd.mobius.daf", "daf");
        add("video/h264", "h264");
        add("application/vnd.dart", "dart");
        add("audio/x-musicnet-stream", "mns");
        add("application/vnd.dna", "dna");
        add("text/vnd.curl.scurl", "scurl");
        add("application/xop+xml", "xop");
        add("video/h261", "h261");
        add("application/x-x_t", "x_t");
        add("application/x-tg4", "tg4");
        add("audio/vnd.dts.hd", "dtshd");
        add("application/vnd.cloanto.rp9", "rp9");
        add("image/x-freehand", "fhc");
        add("application/vnd.data-vision.rdz", "rdz");
        add("application/vnd.adobe.formscentral.fcdt", "fcdt");
        add("application/vnd.hp-hps", "hps");
        add("application/vnd.oasis.opendocument.formula-template", "odft");
        add("application/vnd.3gpp.pic-bw-large", "plb");
        add("application/widget", "wgt");
        add("application/rpki-manifest", "mft");
        add("application/ipfix", "ipfix");
        add("application/vnd.ms-powerpoint", "pwz");
        add("application/x-wq1", "wq1");
        add("application/x-xpinstall", "xpi");
        add("application/jsonml+json", "jsonml");
        add("text/n3", "n3");
        add("text/x-asm", "s");
        add("application/vnd.tao.intent-module-archive", "tao");
        add("application/shf+xml", "shf");
        add("video/vnd.fvt", "fvt");
        add("application/vnd.mcd", "mcd");
        add("application/vnd.nokia.n-gage.data", "ngdat");
        add("application/vnd.geogebra.tool", "ggt");
        add("application/vnd.shana.informed.formdata", "ifm");
        add("application/x-drw", "drw");
        add("application/vnd.intu.qfx", "qfx");
        add("application/font-woff", "woff");
        add("application/vnd.astraea-software.iota", "iota");
        add("application/vnd.lotus-organizer", "org");
        add("application/vnd.rn-realsystem-rjt", "rjt");
        add("application/vnd.hhe.lesson-player", "les");
        add("application/x-301", "301");
        add("application/vnd.unity", "unityweb");
        add("application/voicexml+xml", "vxml");
        add("application/vnd.irepository.package+xml", "irp");
        add("text/vnd.fmi.flexstor", "flx");
        add("model/vnd.dwf", "dwf");
        add("application/cdmi-domain", "cdmid");
        add("application/atom+xml", "atom");
        add("application/x-mac", "mac");
        add("application/x-001", "001");
        add("application/x-lbm", "lbm");
        add("application/x-sam", "sam");
        add("application/vnd.crick.clicker.wordbank", "clkw");
        add("application/vnd.yamaha.smaf-audio", "saf");
        add("application/vnd.ms-pki.pko", "pko");
        add("application/vnd.fdsn.mseed", "mseed");
        add("application/wsdl+xml", "wsdl");
        add("application/vnd.ms-cab-compressed", "cab");
        add("application/vnd.osgi.subsystem", "esa");
        add("text/vnd.dvb.subtitle", "sub");
        add("application/vnd.sema", "sema");
        add("application/vnd.dolby.mlp", "mlp");
        add("application/vnd.seemail", "see");
        add("application/vnd.insors.igm", "igm");
        add("application/vnd.novadigm.edm", "edm");
        add("application/x-mspublisher", "pub");
        add("application/vnd.iphone", "ipa");
        add("application/vnd.hydrostatix.sof-data", "sfd-hdstx");
        add(",	application/x-javascript", "mocha");
        add("application/x-a11", "a11");
        add("application/x-dbf", "dbf");
        add("application/scvp-cv-response", "scs");
        add("application/x-font-linux-psf", "psf");
        add("application/vnd.publishare-delta-tree", "qps");
        add("application/yin+xml", "yin");
        add("application/vnd.adobe.pdx", "pdx");
        add("video/ogg", "ogv");
        add("application/vnd.semf", "semf");
        add("application/x-bzip", "bz");
        add("image/vnd.dece.graphic", "uvvi");
        add("application/x-ms-shortcut", "lnk");
        add("video/x-flv", "flv");
        add("application/mads+xml", "mads");
        add("application/vnd.zzazz.deck+xml", "zaz");
        add("audio/mid", "rmi");
        add("application/x-wb1", "wb1");
        add("application/reginfo+xml", "rif");
        add("application/vnd.lotus-1-2-3", "123");
        add("application/vnd.fujixerox.docuworks.binder", "xbd");
        add("application/x-blorb", "blorb");
        add("application/vnd.novadigm.edx", "edx");
        add("application/vnd.geogebra.file", "ggb");
        add("audio/vnd.ms-playready.media.pya", "pya");
        add("application/vnd.syncml.dm+xml", "xdm");
        add("application/x-x509-ca-cert", "der");
        add("application/vnd.wap.wbxml", "wbxml");
        add("application/cdmi-queue", "cdmiq");
        add("application/x-rle", "rle");
        add("application/vnd.ezpix-album", "ez2");
        add("application/vnd.picsel", "efif");
        add("application/java-serialized-object", "ser");
        add("audio/x-aac", "aac");
        add("application/vnd.musician", "mus");
        add("application/x-msmediaview", "mvb");
        add("application/x-g4", "ig4");
        add("image/x-pict", "pic");
        add("video/mpeg", "mpv2");
        add("application/x-t3vm-image", "t3");
        add("application/vnd.acucorp", "atc");
        add("application/x-mie", "mie");
        add("application/sparql-query", "rq");
        add("application/x-dtbook+xml", "dtb");
        add("application/x-dgn", "dgn");
        add("drawing/x-top", "top");
        add("application/x-prn", "prn");
        add("application/vnd.is-xpr", "xpr");
        add("application/x-hpgl", "hpg");
        add("application/x-wb2", "wb2");
        add("application/vnd.ms-project", "mpx");
        add("application/vnd.pmi.widget", "wg");
        add("application/vnd.crick.clicker.keyboard", "clkk");
        add("application/java-vm", "class");
        add("application/vnd.micrografx.flo", "flo");
        add("application/x-msbinder", "obd");
        add("application/vnd.pg.osasli", "ei6");
        add("application/vnd.ms-powerpoint.addin.macroenabled.12", "ppam");
        add("application/x-ms-application", "application");
        add("application/fractals", "fif");
        add("application/vnd.rn-recording", "rec");
        add(",	audio/x-la-lms", "lmsff");
        add("application/vnd.mobius.mbk", "mbk");
        add("application/x-dxb", "dxb");
        add("application/vnd.rn-realsystem-rmj", "rmj");
        add("application/x-cbr", "cbz");
        add("application/gpx+xml", "gpx");
        add("application/vnd.bmi", "bmi");
        add("application/x-tads", "gam");
        add("image/sgi", "sgi");
        add("application/vnd.commonspace", "csp");
        add("application/vnd.dece.data", "uvvf");
        add("application/relax-ng-compact-syntax", "rnc");
        add("application/java-archive", "jar");
        add("application/x-cfs-compressed", "cfs");
        add("application/vnd.businessobjects", "rep");
        add("application/vnd.mseq", "mseq");
        add("application/vnd.ms-pki.seccat", "cat");
        add("application/xenc+xml", "xenc");
        add("application/vnd.kidspiration", "kia");
        add("application/vnd.ms-excel.template.macroenabled.12", "xltm");
        add("image/ktx", "ktx");
        add("application/javascript", "js");
        add("application/vnd.kenameaapp", "htke");
        add("audio/vnd.lucent.voice", "lvp");
        add("application/x-7z-compressed", "7z");
        add("text/cache-manifest", "appcache");
        add("application/vnd.accpac.simply.imp", "imp");
        add("audio/vnd.dra", "dra");
        add("application/pkcs8", "p8");
        add("application/vnd.kinar", "knp");
        add("application/x-ms-xbap", "xbap");
        add("application/vnd.fujitsu.oasys", "oas");
        add("video/h263", "h263");
        add("application/x-dbm", "dbm");
        add("application/vnd.anser-web-certificate-issue-initiation", "cii");
        add("application/postscript", "ps");
        add("audio/x-pn-realaudio-plugin", "rpm");
        add("application/vnd.fuzzysheet", "fzs");
        add("video/vnd.dece.video", "uvvv");
        add("application/scvp-cv-request", "scq");
        add("application/vnd.geoplan", "g2w");
        add("application/mods+xml", "mods");
        add("application/set-registration-initiation", "setreg");
        add("application/pkixcmp", "pki");
        add("application/vnd.flographit", "gph");
        add("application/vnd.groove-identity-message", "gim");
        add("application/x-mobipocket-ebook", "prc");
        add("application/x-hrf", "hrf");
        add("application/x-c4t", "c4t");
        add("application/timestamped-data", "tsd");
        add("text/x-fortran", "for");
        add("application/vnd.mozilla.xul+xml", "xul");
        add("application/vnd.cluetrust.cartomobile-config-pkg", "c11amz");
        add("application/vnd.proteus.magazine", "mgz");
        add("model/vnd.vtu", "vtu");
        add("application/vnd.anser-web-funds-transfer-initiation", "fti");
        add("application/x-vpeg005", "vpg");
        add("application/x-ltr", "ltr");
        add("application/vnd.mophun.certificate", "mpc");
        add("drawing/907", "907");
        add("application/x-javascript", "ls");
        add("application/vnd.yamaha.hv-voice", "hvp");
        add("application/vnd.groove-help", "ghf");
        add("application/x-director", "w3d");
        add("text/vnd.curl.dcurl", "dcurl");
        add("application/x-csi", "csi");
        add("application/vnd.yamaha.openscoreformat.osfpvg+xml", "osfpvg");
        add("application/vnd.mobius.dis", "dis");
        add("application/vnd.ibm.secure-container", "sc");
        add("application/x-tex-tfm", "tfm");
        add("application/xcap-diff+xml", "xdf");
        add("application/vnd.ms-powerpoint.presentation.macroenabled.12", "pptm");
        add("image/g3fax", "g3");
        add("application/x-wk4", "wk4");
        add("application/vnd.cosmocaller", "cmc");
        add("application/vnd.zul", "zirz");
        add("image/vnd.ms-modi", "mdi");
        add("application/vnd.epson.salt", "slt");
        add("audio/x-mei-aac", "acp");
        add("application/vnd.lotus-screencam", "scm");
        add("model/vrml", "wrl");
        add("application/vnd.fluxtime.clip", "ftc");
        add("application/x-ace-compressed", "ace");
        add("application/vnd.hp-pclxl", "pclxl");
        add("application/x-dtbresource+xml", "res");
        add("application/vnd.rn-rsml", "rsml");
        add("application/vnd.svd", "svd");
        add("image/vnd.net-fpx", "npx");
        add("application/vnd.shana.informed.formtemplate", "itp");
        add("application/vnd.mediastation.cdkey", "cdkey");
        add("application/vnd.tmobile-livetv", "tmo");
        add("application/ssdl+xml", "ssdl");
        add("application/vnd.ms-works", "wps");
        add("application/vnd.solent.sdkm+xml", "sdkm");
        add("application/vnd.3m.post-it-notes", "pwn");
        add("application/vnd.pocketlearn", "plf");
        add("drawing/x-slk", "slk");
        add("video/vnd.vivo", "viv");
        add("application/vnd.mobius.txf", "txf");
        add("application/vnd.blueice.multipass", "mpm");
        add("application/x-pkcs7-certificates", "spc");
        add("application/vnd.epson.msf", "msf");
        add("application/vnd.dece.ttml+xml", "uvvt");
        add("application/vnd.nitf", "ntf");
        add("image/vnd.ms-photo", "wdp");
        add("application/sbml+xml", "sbml");
        add("application/metalink+xml", "metalink");
        add("application/pkcs10", "p10");
        add("application/EDIFACT", "edi");
        add("application/vnd.noblenet-web", "nnw");
        add("audio/vnd.dts", "dts");
        add("application/lost+xml", "lostxml");
        add("application/vnd.fujixerox.ddd", "ddd");
        add("application/x-wkq", "wkq");
        add("application/vnd.acucobol", "acu");
        add("image/vnd.fastbidsheet", "fbs");
        add("application/x-gbr", "gbr");
        add("application/vnd.rn-rn_music_package", "rmp");
        add("application/srgs", "gram");
        add("application/vnd.oasis.opendocument.image-template", "oti");
        add("application/vnd.adobe.xdp", "xdp");
        add("text/x-uuencode", "uu");
        add("application/vnd.enliven", "nml");
        add("application/x-perl", "pl");
        add("application/x-c90", "c90");
        add("application/cu-seeme", "cu");
        add("application/x-wr1", "wr1");
        add("application/vnd.fdsn.seed", "seed");
        add("text/x-sfv", "sfv");
        add("application/mediaservercontrol+xml", "mscml");
        add("audio/s3m", "s3m");
        add("application/vnd.frogans.ltf", "ltf");
        add("application/dssc+xml", "xdssc");
        add("application/vnd.hp-hpid", "hpid");
        add("text/vnd.curl", "curl");
        add("application/omdoc+xml", "omdoc");
        add("application/x-mmxp", "mxp");
        add("application/oebps-package+xml", "opf");
        add("application/vnd.oasis.opendocument.chart-template", "otc");
        add("application/vnd.ms-powerpoint.slide.macroenabled.12", "sldm");
        add("application/vnd.ms-excel.sheet.macroenabled.12", "xlsm");
        add("application/vnd.genomatix.tuxedo", "txd");
        add("application/vnd.pawaafile", "paw");
        add("text/x-nfo", "nfo");
        add("application/vnd.dpgraph", "dpg");
        add("application/vnd.ms-word.document.macroenabled.12", "docm");
        add("application/vnd.crick.clicker.palette", "clkp");
        add("application/x-img", "img");
        add("application/ssml+xml", "ssml");
        add("application/vnd.groove-tool-message", "gtm");
        add("application/x-tgif", "obj");
        add("application/x-sat", "sat");
        add("application/vnd.ms-fontobject", "eot");
        add("application/vnd.syncml+xml", "xsm");
        add("application/vnd.epson.quickanime", "qam");
        add("application/vnd.uoml+xml", "uoml");
        add("video/mp4", "mpg4");
        add("application/xaml+xml", "xaml");
        add("application/vnd.shana.informed.interchange", "iif");
        add("application/xml-dtd", "dtd");
        add("text/vnd.curl.mcurl", "mcurl");
        add("application/x-sh", "sh");
        add("application/vnd.kde.kivio", "flw");
        add("chemical/x-cml", "cml");
        add("application/x-msdownload", "exe");
        add("application/x-plt", "plt");
        add("application/set-payment-initiation", "setpay");
        add("application/vnd.spotfire.sfs", "sfs");
        add("application/x-wb3", "wb3");
        add("application/x-sql", "sql");
        add("application/applixware", "aw");
        add("application/vnd.wap.wmlc", "wmlc");
        add("application/vnd.syncml.dm+wbxml", "bdm");
        add("chemical/x-cmdf", "cmdf");
        add("audio/x-musicnet-download", "mnd");
        add("video/jpeg", "jpgv");
        add("application/x-mscardfile", "crd");
        add("application/font-tdpfr", "pfr");
        add("application/x-research-info-systems", "ris");
        add("chemical/x-cif", "cif");
        add("application/vnd.groove-vcard", "vcg");
        add("application/vnd.cluetrust.cartomobile-config", "c11amc");
        add("image/fax", "fax");
        add("application/vnd.adobe.xfdf", "xfdf");
        add("application/x-prt", "prt");
        add("application/vnd.iccprofile", "icm");
        add("application/vnd.fsc.weblaunch", "fsc");
        add("model/x3d+binary", "x3dbz");
        add("application/rsd+xml", "rsd");
        add("application/patch-ops-error+xml", "xer");
        add("application/vnd.ufdl", "ufdl");
        add("application/vnd.ms-wpl", "wpl");
        add("image/vnd.fujixerox.edmics-rlc", "rlc");
        add("application/x-dib", "dib");
        add("application/x-wp6", "wp6");
        add("application/x-bzip2", "bz2");
        add("application/vnd.intercon.formnet", "xpx");
        add("application/vnd.ms-ims", "ims");
        add("application/vnd.visio", "vtx");
        add("application/postscript", "eps");
        add("application/vnd.realvnc.bed", "bed");
        add("application/x-cot", "cot");
        add("text/webviewhtml", "htt");
        add("application/vnd.osgeo.mapguide.package", "mgp");
        add("application/vnd.adobe.rmf", "rmf");
        add("application/vnd.3gpp2.tcap", "tcap");
        add("application/vnd.airzip.filesecure.azf", "azf");
        add("application/x-authorware-map", "aam");
        add("application/x-zmachine", "z8");
        add("model/x3d+vrml", "x3dvz");
        add("application/vnd.ms-artgalry", "cil");
        add("text/vnd.wap.wmlscript", "wmls");
        add("image/vnd.rn-realpix", "rp");
        add("image/vnd.fst", "fst");
        add("application/vnd.sus-calendar", "susp");
        add("application/vnd.criticaltools.wbs+xml", "wbs");
        add("application/vnd.las.las+xml", "lasxml");
        add("application/rpki-roa", "roa");
        add("application/scvp-vp-request", "spq");
        add("application/vnd.nokia.n-gage.symbian.install", "n-gage");
        add("application/ogg", "ogx");
        add("application/srgs+xml", "grxml");
        add("application/pskc+xml", "pskcxml");
        add("application/vnd.xara", "xar");
        add("application/vnd.triscape.mxs", "mxs");
        add("application/vnd.olpc-sugar", "xo");
        add("text/vnd.in3d.3dml", "3dml");
        add("application/vnd.fujitsu.oasys2", "oa2");
        add("application/prs.cww", "cww");
        add("application/vnd.frogans.fnc", "fnc");
        add("application/resource-lists-diff+xml", "rld");
        add("application/vnd.medcalcdata", "mc1");
        add("application/hyperstudio", "stk");
        add("application/vnd.smart.teacher", "teacher");
        add("application/x-gca-compressed", "gca");
        add("application/vnd.osgi.dp", "dp");
        add("message/rfc822", "nws");
        add("application/x-smk", "smk");
        add("application/vnd.amiga.ami", "ami");
        add("text/vnd.fly", "fly");
        add("application/x-cals", "cal");
        add("audio/adpcm", "adp");
        add("application/vnd.yamaha.openscoreformat", "osf");
        add("application/vnd.quark.quarkxpress", "qxt");
        add("video/vnd.dece.mobile", "uvvm");
        add("text/x-opml", "opml");
        add("application/ecmascript", "ecma");
        add("video/x-mpg", "mpa");
        add("application/x-cit", "cit");
        add("application/vnd.hp-hpgl", "hpgl");
        add("application/vnd.recordare.musicxml+xml", "musicxml");
        add("application/vnd.stepmania.package", "smzip");
        add("application/vnd.ahead.space", "ahead");
        add("application/cdmi-capability", "cdmia");
        add("application/x-stuffitx", "sitx");
        add("application/xproc+xml", "xpl");
        add("application/x-906", "906");
        add("application/x-pgl", "pgl");
        add("application/x-font-snf", "snf");
        add("application/vnd.groove-tool-template", "tpl");
        add("application/vnd.rn-realsystem-rmx", "rmx");
        add("application/x-slb", "slb");
        add("text/asp", "asp");
        add("application/x-pkcs12", "pfx");
        add("model/vnd.gtw", "gtw");
        add("application/vnd.wqd", "wqd");
        add("application/vnd.route66.link66+xml", "link66");
        add("application/x-msmoney", "mny");
        add("chemical/x-xyz", "xyz");
        add("application/vnd.neurolanguage.nlu", "nlu");
        add("application/x-hmr", "hmr");
        add("application/vnd.mophun.application", "mpn");
        add("application/vnd.noblenet-directory", "nnd");
        add("application/xslt+xml", "xslt");
        add("text/sgml", "sgml");
        add("application/vnd.claymore", "cla");
        add("application/x-envoy", "evy");
        add("application/x-font-bdf", "bdf");
        add("application/vnd.llamagraphics.life-balance.desktop", "lbd");
        add("application/x-msterminal", "trm");
        add("audio/x-matroska", "mka");
        add("application/vnd.accpac.simply.aso", "aso");
        add("application/vnd.rn-realplayer", "rnx");
        add("application/vnd.lotus-approach", "apr");
        add("application/vnd.dece.zip", "uvz");
        add("application/x-conference", "nsc");
        add("application/pkcs7-mime", "p7m");
        add("application/vnd.webturbo", "wtb");
        add("application/pkix-pkipath", "pkipath");
        add("video/vnd.uvvu.mp4", "uvvu");
        add("application/vnd.airzip.filesecure.azs", "azs");
        add("application/x-wks", "wks");
        add("audio/mp1", "mp1");
        add("application/vnd.simtech-mindmapper", "twds");
        add("application/winhlp", "hlp");
        add("application/vnd.dvb.service", "svc");
        add("application/vnd.mobius.msl", "msl");
        add("application/xml", "xsl");
        add("application/vnd.ibm.modcap", "listafp");
        add("application/vnd.pg.format", "str");
        add("application/vnd.uiq.theme", "utz");
        add("application/vnd.fujitsu.oasysgp", "fg5");
        add("application/x-eva", "eva");
        add("audio/ogg", "spx");
        add("application/vnd.noblenet-sealer", "nns");
        add("application/vnd.wap.wmlscriptc", "wmlsc");
        add("application/x-dcx", "dcx");
        add("application/vnd.hp-jlyt", "jlt");
        add("application/vnd.kodak-descriptor", "sse");
        add("image/vnd.fujixerox.edmics-mmr", "mmr");
        add("audio/mp4", "mp4a");
        add("application/vnd.lotus-notes", "nsf");
        add("application/vnd.adobe.xfd", "xfd");
        add("application/streamingmedia", "ssm");
        add("application/vnd.fujixerox.docuworks", "xdw");
        add("video/vnd.dece.pd", "uvvp");
        add("application/x-red", "red");
        add("application/vnd.antix.game-component", "atx");
        add("application/ccxml+xml", "ccxml");
        add("application/x-freearc", "arc");
        add("application/x-silverlight-app", "xap");
        add("application/vnd.adobe.air-application-installer-package+zip", "air");
        add("audio/webm", "weba");
        add("application/x-laplayer-reg", "lar");
        add("application/x-wk3", "wk3");
        add("text/turtle", "ttl");
        add("application/x-emf", "emf");
        add("application/vnd.denovo.fcselayout-link", "fe_launch");
        add("application/x-authorware-seg", "aas");
        add("application/vnd.kde.kontour", "kon");
        add("application/vnd.fujitsu.oasys3", "oa3");
        add("application/vnd.spotfire.dxp", "dxp");
        add("application/vnd.gmx", "gmx");
        add("video/x-smv", "smv");
        add("application/x-wrk", "wrk");
        add("application/x-wpd", "wpd");
        add("application/vnd.kde.karbon", "karbon");
        add("application/xspf+xml", "xspf");
        add("video/x-ivf", "IVF");
        add("image/vnd.dxf", "dxf");
        add("application/vnd.tcpdump.pcap", "pcap");
        add("application/vnd.ms-xpsdocument", "xps");
        add("application/x-chat", "chat");
        add("application/exi", "exi");
        add("model/vnd.collada+xml", "dae");
        add("application/vnd.kahootz", "ktz");
        add("application/vnd.apple.mpegurl", "m3u8");
        add("application/x-tdf", "tdf");
        add("text/vcard", "vcard");
        add("application/vnd.fujitsu.oasysprs", "bh2");
        add("application/vnd.nokia.radio-presets", "rpss");
        add("application/vnd.palm", "pqa");
        add("application/vnd.kde.kformula", "kfo");
        add("application/vnd.amazon.ebook", "azw");
        add("audio/silk", "sil");
        add("application/vnd.stepmania.stepchart", "sm");
        add("application/vnd.rn-realsystem-rjs", "rjs");
        add("application/vnd.ds-keypoint", "kpxx");
        add("video/vnd.rn-realvideo", "rv");
        add("application/atomsvc+xml", "atomsvc");
        add("application/x-java-jnlp-file", "jnlp");
        add("application/mathml+xml", "mathml");
        add("application/json", "json");
        add("application/vnd.dreamfactory", "dfac");
        add("image/pnetvue", "net");
        add("application/vnd.ctc-posml", "pml");
        add("application/vnd.vsf", "vsf");
        add("application/smil", "smil");
        add("application/wspolicy+xml", "wspolicy");
        add("application/cdmi-container", "cdmic");
        add("application/oxps", "oxps");
        add("application/x-cel", "cel");
        add("application/vnd.ibm.rights-management", "irm");
        add("application/vnd.mynfc", "taglet");
        add("application/marc", "mrc");
        add("application/onenote", "onetoc2");
        add("video/mj2", "mjp2");
        add("application/pkix-cert", "cer");
        add("application/x-g4l", "cg4");
        add("application/inkml+xml", "inkml");
        add("application/vnd.jam", "jam");
        add("application/vnd.grafeq", "gqs");
        add("text/scriptlet", "wsc");
        add("application/x-hpl", "hpl");
        add("application/x-glulx", "ulx");
        add("video/x-matroska", "mkv");
        add("application/vnd.yamaha.hv-dic", "hvd");
        add("application/vnd.trueapp", "tra");
        add("application/vnd.crick.clicker", "clkx");
        add("application/vnd.eszigno3+xml", "et3");
        add("application/vnd.rig.cryptonote", "cryptonote");
        add("application/x-tga", "tga");
        add("application/x-gp4", "gp4");
        add("video/mpg", "mpv");
        add("application/vnd.ms-excel.addin.macroenabled.12", "xlam");
        add("application/vnd.immervision-ivu", "ivu");
        add("application/vnd.curl.car", "car");
        add("application/x-mil", "mil");
        add("application/x-nrf", "nrf");
        add("application/davmount+xml", "davmount");
        add("application/vnd.oma.dd2+xml", "dd2");
        add("text/vnd.rn-realtext3d", "r3t");
        add(",	message/rfc822", "mhtml");
        add("application/pgp-signature", "sig");
        add("application/x-xlw", "xlw");
        add("image/vnd.dwg", "dwg");
        add("application/vnd.contact.cmsg", "cdbcmsg");
        add("application/vnd.audiograph", "aep");
        add("application/vnd.clonk.c4group", "c4u");
        add("application/vnd.groove-account", "gac");
        add("application/vnd.ms-powerpoint.slideshow.macroenabled.12", "ppsm");
        add("application/vnd.apple.installer+xml", "mpkg");
        add("application/x-sld", "sld");
        add("chemical/x-csml", "csml");
        add("text/vnd.graphviz", "gv");
        add("application/metalink4+xml", "meta4");
        add("application/x-wmf", "wmf");
        add("application/vnd.macports.portpkg", "portpkg");
        add("application/vnd.ms-lrm", "lrm");
        add("application/x-nzb", "nzb");
        add("application/gxf", "gxf");
        add("application/vnd.recordare.musicxml", "mxl");
        add("audio/vnd.rip", "rip");
        add("application/pkix-attr-cert", "ac");
        add("application/dssc+der", "dssc");
        add("application/xv+xml", "xvml");
        add("application/msword", "wiz");
        add("text/uri-list", "urls");
        add("application/vnd.ibm.minipay", "mpy");
        add("audio/vnd.nuera.ecelp4800", "ecelp4800");
        add("application/vnd.dece.unspecified", "uvx");
        add("audio/vnd.dece.audio", "uvva");
        add("application/vnd.joost.joda-archive", "joda");
        add("application/sparql-results+xml", "srx");
        add("application/vnd.semd", "semd");
        add("application/vnd.trid.tpt", "tpt");
        add("text/vnd.rn-realtext", "rt");
        add("audio/xm", "xm");
        add("application/vnd.ezpix-package", "ez3");
        add("application/vnd.vcx", "vcx");
        add("application/vnd.geometry-explorer", "gre");
        add("application/scvp-vp-response", "spp");
        add("application/x-wpg", "wpg");
        add("application/x-xz", "xz");
        add("application/x-pc5", "pc5");
        add("application/vnd.ms-excel.sheet.binary.macroenabled.12", "xlsb");
        add("application/vnd.rn-realmedia-vbr", "rmvb");
        add("text/vnd.sun.j2me.app-descriptor", "jad");
        add("application/vnd.mobius.plc", "plc");
        add("application/rls-services+xml", "rs");
        add("application/x-install-instructions", "install");
        add("application/sru+xml", "sru");
        add("application/x-hgl", "hgl");
        add("application/atomcat+xml", "atomcat");
        add("application/vnd.visionary", "vis");
        add("application/x-font-ttf", "ttf");
        add("application/vnd.cups-ppd", "ppd");
        add("audio/x-liquid-file", "la1");
        add("application/vnd.dynageo", "geo");
        add("application/tei+xml", "teicorpus");
        add("application/vnd.wt.stf", "stf");
        add("application/vnd.mfer", "mwf");
        add("application/vnd.yamaha.smaf-phrase", "spf");
        add("application/emma+xml", "emma");
        add("video/vnd.dece.sd", "uvvs");
        add("application/vnd.chipnuts.karaoke-mmd", "mmd");
        add("application/vnd.sailingtracker.track", "st");
        add("application/vnd.crick.clicker.template", "clkt");
        add("application/vnd.openofficeorg.extension", "oxt");
        add("application/vnd.yamaha.hv-script", "hvs");
        add("application/vnd.ms-officetheme", "thmx");
        add("application/vnd.jisp", "jisp");
        add("application/vnd.isac.fcs", "fcs");
        add("application/vnd.oasis.opendocument.presentation-template", "otp");
        add("application/vnd.llamagraphics.life-balance.exchange+xml", "lbe");
        add("application/x-pcl", "pcl");
        add("application/x-vda", "vda");
        add("application/x-xliff+xml", "xlf");
        add("application/vnd.aristanetworks.swi", "swi");
        add("application/x-font-otf", "otf");
        add("application/vnd.intergeo", "i2g");
        add("image/vnd.fpx", "fpx");
        add("application/marcxml+xml", "mrcx");
        add("application/x-vst", "vst");
        add("application/vnd.epson.esf", "esf");
        add("application/x-icb", "icb");
        add("application/vnd.adobe.workflow", "awf");
        add("application/x-icq", "uin");
        add("application/x-pci", "pci");
        add("text/vnd.wap.wml", "wml");
        add("video/jpm", "jpm");
        add("application/x-subrip", "srt");
        add("audio/x-liquid-secure", "lavs");
        add("application/x-dgc-compressed", "dgc");
        add("application/yang", "yang");
        add("application/vnd.geonext", "gxt");
        add("application/mbox", "mbox");
        add("application/vnd.handheld-entertainment+xml", "zmm");
        add("application/vnd.nokia.radio-preset", "rpst");
        add("model/vnd.mts", "mts");
        add("application/cdmi-object", "cdmio");
        add("application/x-msclip", "clp");
        add("video/vnd.dvb.file", "dvb");
        add("text/troff", "tr");
        add("application/vnd.geospace", "g3w");
        add("image/prs.btif", "btif");
        add("image/vnd.xiff", "xif");
        add("application/x-dtbncx+xml", "ncx");
        add("text/x-ms-odc", "odc");
        add("application/x-epi", "epi");
        add("application/resource-lists+xml", "rl");
        add("application/vnd.intu.qbo", "qbo");
        add("application/vnd.epson.ssf", "ssf");
        add("application/x-anv", "anv");
        add("application/epub+zip", "epub");
        add("application/vnd.ms-htmlhelp", "chm");
        add("application/vnd.3gpp.pic-bw-small", "psb");
        add("audio/x-caf", "caf");
        add("text/asa", "asa");
        add("application/vnd.americandynamics.acc", "acc");
        add("text/calendar", "ifb");
        add("application/vnd.jcp.javame.midlet-rms", "rms");
        add("video/vnd.ms-playready.media.pyv", "pyv");
        add("application/vnd.igloader", "igl");
        add("application/gml+xml", "gml");
        add("application/vnd.ecowin.chart", "mag");
        add("application/vnd.ipunplugged.rcprofile", "rcprofile");
        add("application/thraud+xml", "tfi");
        add("application/rat-file", "rat");
        add("application/mxf", "mxf");
        add("application/vnd.lotus-wordpro", "lwp");
        add("audio/x-pn-realaudio", "rmm");
        add("model/vnd.gdl", "gdl");
        add("application/vnd.ms-powerpoint.template.macroenabled.12", "potm");
        add("application/pkcs7-signature", "p7s");
        add("application/vnd.muvee.style", "msty");
        add("application/vnd.micrografx.igx", "igx");
        add("application/vnd.hal+xml", "hal");
        add("audio/vnd.nuera.ecelp7470", "ecelp7470");
        add("application/vnd.xfdl", "xfdl");
        add("application/vnd.lotus-freelance", "pre");
        add("application/x-cmp", "cmp");
        add("video/x-mpeg", "mps");
        add("application/vnd.adobe.edn", "edn");
        add("audio/vnd.digital-winds", "eol");
        add("application/x-cmx", "cmx");
        add("application/x-ws", "ws2");
        add("application/x-cgm", "cgm");
        add("application/vnd.powerbuilder6", "pbd");
        add("application/mets+xml", "mets");
        add("application/vnd.curl.pcurl", "pcurl");
        add("application/x-iff", "iff");
        add("application/vnd.dvb.ait", "ait");
        add("application/x-ptn", "ptn");
        add("application/x-wri", "wri");
        add("application/x-ebx", "etd");
        add("application/vnd.previewsystems.box", "box");
        add("application/vnd.chemdraw+xml", "cdxml");
        add("video/x-f4v", "f4v");
        add("application/x-gramps-xml", "gramps");
        add("application/vnd.hbci", "hbci");
        add("application/docbook+xml", "dbk");
        add("application/x-msschedule", "scd");
        add("application/vnd.pvi.ptid1", "ptid");
        add("application/vnd.adobe.fxp", "fxpl");
        add("application/vnd.mobius.mqy", "mqy");
        add("application/vnd.shana.informed.package", "ipk");
        add("application/mp21", "mp21");
        add("application/vnd.wolfram.player", "nbp");
        add("application/vnd.immervision-ivp", "ivp");
        add("chemical/x-cdx", "cdx");
        add("application/x-authorware-bin", "x32");
        add("image/webp", "webp");
        add("application/gzip", "gzip");
        add("audio/vnd.nuera.ecelp9600", "ecelp9600");
        add("text/vnd.in3d.spot", "spot");
        add("application/vnd.fdf", "fdf");
        add("video/vnd.dece.hd", "uvvh");
        add("application/x-cut", "cut");
        add("application/vnd.openxmlformats-officedocument.presentationml.slide", "sldx");
        add("video/x-ms-vob", "vob");
        add("image/x-3ds", "3ds");
        add("application/x-mi", "mi");
        add("application/vnd.groove-injector", "grv");
        add("application/mp4", "mp4s");
        add("model/x3d+xml", "x3dz");
        add("application/x-x_b", "x_b");
        add("application/vnd.oasis.opendocument.presentation", "odp");
        add("application/x-gl2", "gl2");
        add("application/x-font-type1", "pfm");
        add("application/vnd.ms-pki.certstore", "sst");
        add("application/vnd.mfmp", "mfm");
        add("application/vnd.novadigm.ext", "ext");
        add("application/x-bot             ", "bot");
        add("application/vnd.umajin", "umj");
        add("application/vnd.ms-word.template.macroenabled.12", "dotm");
        add("application/vnd.3gpp.pic-bw-var", "pvb");
        add("application/x-out", "out");
        add("application/x-pr", "pr");
        add("text/prs.lines.tag", "dsc");

        applyOverrides();
    }

    private static void add(String mimeType, String extension) {
        //
        // if we have an existing x --> y mapping, we do not want to
        // override it with another mapping x --> ?
        // this is mostly because of the way the mime-type map below
        // is constructed (if a mime type maps to several extensions
        // the first extension is considered the most popular and is
        // added first; we do not want to overwrite it later).
        //
        if (!mimeTypeToExtensionMap.containsKey(mimeType)) {
            mimeTypeToExtensionMap.put(mimeType, extension);
        }
        if (!extensionToMimeTypeMap.containsKey(extension)) {
            extensionToMimeTypeMap.put(extension, mimeType);
        }
    }

    private static InputStream getContentTypesPropertiesStream() {
        // User override?
        String userTable = System.getProperty("content.types.user.table");
        if (userTable != null) {
            File f = new File(userTable);
            if (f.exists()) {
                try {
                    return new FileInputStream(f);
                } catch (IOException ignored) {
                }
            }
        }

        // Standard location?
        File f = new File(System.getProperty("java.home"), "lib" + File.separator + "content-types.properties");
        if (f.exists()) {
            try {
                return new FileInputStream(f);
            } catch (IOException ignored) {
            }
        }

        return null;
    }

    /**
     * This isn't what the RI does. The RI doesn't have hard-coded defaults, so supplying your
     * own "content.types.user.table" means you don't get any of the built-ins, and the built-ins
     * come from "$JAVA_HOME/lib/content-types.properties".
     */
    private static void applyOverrides() {
        // Get the appropriate InputStream to read overrides from, if any.
        InputStream stream = getContentTypesPropertiesStream();
        if (stream == null) {
            return;
        }
        try {
            try {
                // Read the properties file...
                Properties overrides = new Properties();
                overrides.load(stream);
                // And translate its mapping to ours...
                for (Map.Entry<Object, Object> entry : overrides.entrySet()) {
                    String extension = (String) entry.getKey();
                    String mimeType = (String) entry.getValue();
                    add(mimeType, extension);
                }
            } finally {
                stream.close();
            }
        } catch (IOException ignored) {
        }
    }


    /**
     * Returns true if the given MIME type has an entry in the map.
     *
     * @param mimeType A MIME type (i.e. text/plain)
     * @return True iff there is a mimeType entry in the map.
     */
    public static boolean hasMimeType(String mimeType) {
        if (mimeType == null || mimeType.isEmpty()) {
            return false;
        }
        return mimeTypeToExtensionMap.containsKey(mimeType);
    }

    /**
     * Returns the MIME type for the given extension.
     *
     * @param extension A file extension without the leading '.'
     * @return The MIME type for the given extension or null iff there is none.
     */
    public static String guessMimeTypeFromExtension(String extension) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }
        return extensionToMimeTypeMap.get(extension);
    }

    /**
     * Returns true if the given extension has a registered MIME type.
     *
     * @param extension A file extension without the leading '.'
     * @return True iff there is an extension entry in the map.
     */
    public static boolean hasExtension(String extension) {
        if (extension == null || extension.isEmpty()) {
            return false;
        }
        return extensionToMimeTypeMap.containsKey(extension);
    }

    /**
     * Returns the registered extension for the given MIME type. Note that some
     * MIME types map to multiple extensions. This call will return the most
     * common extension for the given MIME type.
     *
     * @param mimeType A MIME type (i.e. text/plain)
     * @return The extension for the given MIME type or null iff there is none.
     */
    public static String guessExtensionFromMimeType(String mimeType) {
        if (mimeType == null || mimeType.isEmpty()) {
            return null;
        }
        return mimeTypeToExtensionMap.get(mimeType);
    }


}
