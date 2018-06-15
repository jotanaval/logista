CREATE TABLE public.agenda
(
  id integer NOT NULL DEFAULT nextval('agenda_id_seq'::regclass),
  dataexecfaxina date,
  datasolicitacao date,
  executor character varying(255),
  faxina character varying(2000),
  lancador character varying(255),
  observacaoes character varying(2000),
  solucaoimpl character varying(2000),
  CONSTRAINT agenda_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.agenda
  OWNER TO postgres;


CREATE TABLE public.cadastroip
(
  ip_id integer NOT NULL DEFAULT nextval('cadastroip_ip_id_seq'::regclass),
  datasolicitacao date,
  datavencimento date,
  faixaliberada character varying(255),
  nomedocadastrante character varying(255),
  nomedosolicitante character varying(255),
  omsolicitante character varying(255),
  CONSTRAINT cadastroip_pkey PRIMARY KEY (ip_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.cadastroip
  OWNER TO postgres;

CREATE TABLE public.grupo
(
  nome character varying(255) NOT NULL,
  CONSTRAINT grupo_pkey PRIMARY KEY (nome)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.grupo
  OWNER TO postgres;

CREATE TABLE public.material
(
  material_id integer NOT NULL DEFAULT nextval('material_material_id_seq'::regclass),
  descricao character varying(255),
  entradaoperacao date,
  numeromatricial character varying(255),
  situacaoatual character varying(255),
  tipo character varying(255),
  valor character varying(255),
  vidautil character varying(255),
  CONSTRAINT material_pkey PRIMARY KEY (material_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.material
  OWNER TO postgres;
CREATE TABLE public.militar
(
  id integer NOT NULL DEFAULT nextval('militar_id_seq'::regclass),
  classetiro character varying(255),
  cursos character varying(255),
  dataultima date,
  datavalidade date,
  datavencimentotiro date,
  dispensa character varying(255),
  endereco character varying(255),
  identidade character varying(255),
  nip character varying(255),
  nome character varying(255),
  nomefamiliar character varying(255),
  pontuacao character varying(255),
  resultado character varying(255),
  telcel character varying(255),
  telcontato character varying(255),
  telconvencional character varying(255),
  CONSTRAINT militar_pkey PRIMARY KEY (id),
  CONSTRAINT uk_awdjiqobh4ntv4kkcrn96854n UNIQUE (nip)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.militar
  OWNER TO postgres;


CREATE TABLE public.parck
(
  id integer NOT NULL DEFAULT nextval('parck_id_seq'::regclass),
  cadastrante character varying(100),
  dataaquisicao date,
  hd character varying(200),
  ip character varying(100),
  macaddress character varying(100),
  marca character varying(200),
  memoria character varying(200),
  nip character varying(100),
  nome character varying(100),
  nomedeguerra character varying(100),
  numeroetiqueta character varying(100),
  numerolacre character varying(100),
  om character varying(100),
  processador character varying(200),
  setorresponsavel character varying(100),
  sistemaoperacional character varying(100),
  tipo character varying(100),
  CONSTRAINT parck_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.parck
  OWNER TO postgres;


CREATE TABLE public.usuario
(
  id bigint NOT NULL,
  ativo boolean NOT NULL,
  celular character varying(255),
  email character varying(255),
  login character varying(255),
  nome character varying(255),
  om character varying(255),
  senha character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (id),
  CONSTRAINT uk_g1orfqvgih1w8s3vyg15fq2b8 UNIQUE (login)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO postgres;



CREATE TABLE public.usuario_permissao
(
  usuario bigint NOT NULL,
  permissao character varying(50),
  CONSTRAINT fkbmd8sq2pbko7v7w3xoryyjbgw FOREIGN KEY (usuario)
      REFERENCES public.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uksent4jkw3tncsd39oduptyq3j UNIQUE (usuario, permissao)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario_permissao
  OWNER TO postgres;
