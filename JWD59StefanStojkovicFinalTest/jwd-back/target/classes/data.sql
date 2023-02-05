INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (1, "Serbia", "SRB");
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (2, "Macedonia", "MKD");
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (3, "United States", "USD");
INSERT INTO reprezentacija(id, naziv, skraceni_naziv) VALUES (4, "Great Britain", "GBR");

INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, broj_golovaa, broj_golovab) VALUES (1, 2, 3, 2, 5);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, broj_golovaa, broj_golovab) VALUES (2, 4, 1, 0, 0);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, broj_golovaa, broj_golovab) VALUES (3, 1, 2, 2, 3);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, broj_golovaa, broj_golovab) VALUES (4, 4, 3, 1, 2);

INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (1, "Stefan", "Stojkovic", 34, 1);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (2, "Stefanopolus", "Stojkov", 14, 3);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (3, "Stefanci", "Stojkovitis", 30, 2);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (4, "Stef", "Stojkales", 10, 4);