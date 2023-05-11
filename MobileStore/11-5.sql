use MobileStore

select  HoaDon1.*,HoaDon1.soluong*HoaDon1.giaban as TongThanhToan,(HoaDon1.soluong*HoaDon1.giaban)-(HoaDon1.soluong*Kho.dongia) as TienLai from HoaDon1,Kho where Kho.masp=HoaDon1.masp and month(ngayxuat)='10' 
select  HoaDon1.mahd,HoaDon1.ngayxuat,HoaDon1.masp,HoaDon1.soluong,SanPham.giaban,HoaDon1.soluong*SanPham.giaban as TongThanhToan from HoaDon1,SanPham where HoaDon1.masp=SanPham.masp


select NhanVien.manv,tennv,Luong.songaycong,(NhanVien.luongcoban/30)*Luong.songaycong as LuongThucNhan from NhanVien,Luong where NhanVien.manv=Luong.manv 

select * from NguoiDung
select * from Kho

delete from HoaDon1 where mahd='hd05'
select * from HoaDon1
update Luong set songaycong='13' where manv='nv01'
update Luong set songaycong='"+txtluongsongaycong.getText()+"' where manv='"+txtluongmanv+"'


insert into HoaDon1 values('hd04','2010/10/10','dt03','3','10000000')


declare @UpdateSLMay int
select  @UpdateSLMay = Kho.soluong from Kho,HoaDon1 where  Kho.soluong=HoaDon1.soluong


update Kho set Kho.soluong = Kho.soluong- HoaDon1.soluong from Kho,HoaDon1  where HoaDon1.masp=Kho.masp and HoaDon1.mahd='hd02' 
drop trigger CapNhatSL
create trigger CapNhatSL 
on HoaDon1 for insert 
as
begin 
update Kho set Kho.soluong = Kho.soluong- HoaDon1.soluong from Kho,HoaDon1  where HoaDon1.masp=Kho.masp and HoaDon1.mahd='hd02' 
end

ALTER TABLE NhanVien
  add hinhanh nvarchar(500);
  select * from NhanVien

ALTER TABLE Kho
  add hinhanh nvarchar(500);
  select * from NhanVien

ALTER TABLE NhanVien
DROP COLUMN hinhanh