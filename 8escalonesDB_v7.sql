PGDMP      %            
    |            8_escalones    17.0    17.0 &    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    32885    8_escalones    DATABASE     �   CREATE DATABASE "8_escalones" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Argentina.1252';
    DROP DATABASE "8_escalones";
                     postgres    false            �           0    0    SCHEMA public    ACL     +   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
                        pg_database_owner    false    5            �            1259    32887    admin    TABLE     q   CREATE TABLE public.admin (
    id integer NOT NULL,
    usuario text NOT NULL,
    contrasenia text NOT NULL
);
    DROP TABLE public.admin;
       public         heap r       postgres    false            �            1259    32892    admin_id_seq    SEQUENCE     �   ALTER TABLE public.admin ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    217            �            1259    32893    participantes    TABLE     ~   CREATE TABLE public.participantes (
    id integer NOT NULL,
    nombre text NOT NULL,
    veces_ganadas integer DEFAULT 0
);
 !   DROP TABLE public.participantes;
       public         heap r       postgres    false            �            1259    32948    participantes_id_seq    SEQUENCE     �   ALTER TABLE public.participantes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.participantes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    219            �            1259    32900 	   preguntas    TABLE     �   CREATE TABLE public.preguntas (
    id_pregunta integer NOT NULL,
    pregunta text NOT NULL,
    id_tema integer NOT NULL,
    id_tipopregunta integer
);
    DROP TABLE public.preguntas;
       public         heap r       postgres    false            �            1259    32905    preguntas_id_seq    SEQUENCE     �   ALTER TABLE public.preguntas ALTER COLUMN id_pregunta ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.preguntas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    220            �            1259    32906 
   respuestas    TABLE     �   CREATE TABLE public.respuestas (
    id_respuesta integer NOT NULL,
    respuesta text,
    id_pregunta integer,
    respuesta_correcta boolean
);
    DROP TABLE public.respuestas;
       public         heap r       postgres    false            �            1259    32985    respuestas_id_respuesta_seq    SEQUENCE     �   ALTER TABLE public.respuestas ALTER COLUMN id_respuesta ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.respuestas_id_respuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    222            �            1259    32911    tema    TABLE     Z   CREATE TABLE public.tema (
    id_tema integer NOT NULL,
    nombre_tema text NOT NULL
);
    DROP TABLE public.tema;
       public         heap r       postgres    false            �            1259    32982    tema_id_tema_seq    SEQUENCE     �   ALTER TABLE public.tema ALTER COLUMN id_tema ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tema_id_tema_seq
    START WITH 11
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    223            �            1259    32916    tipo_pregunta    TABLE     i   CREATE TABLE public.tipo_pregunta (
    id_tipo integer NOT NULL,
    tipo_pregunta character varying
);
 !   DROP TABLE public.tipo_pregunta;
       public         heap r       postgres    false            �            1259    32986    tipo_pregunta_id_tipo_seq    SEQUENCE     �   ALTER TABLE public.tipo_pregunta ALTER COLUMN id_tipo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tipo_pregunta_id_tipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    224            �          0    32887    admin 
   TABLE DATA           9   COPY public.admin (id, usuario, contrasenia) FROM stdin;
    public               postgres    false    217   b*       �          0    32893    participantes 
   TABLE DATA           B   COPY public.participantes (id, nombre, veces_ganadas) FROM stdin;
    public               postgres    false    219   �*       �          0    32900 	   preguntas 
   TABLE DATA           T   COPY public.preguntas (id_pregunta, pregunta, id_tema, id_tipopregunta) FROM stdin;
    public               postgres    false    220   �*       �          0    32906 
   respuestas 
   TABLE DATA           ^   COPY public.respuestas (id_respuesta, respuesta, id_pregunta, respuesta_correcta) FROM stdin;
    public               postgres    false    222   7-       �          0    32911    tema 
   TABLE DATA           4   COPY public.tema (id_tema, nombre_tema) FROM stdin;
    public               postgres    false    223   X0       �          0    32916    tipo_pregunta 
   TABLE DATA           ?   COPY public.tipo_pregunta (id_tipo, tipo_pregunta) FROM stdin;
    public               postgres    false    224   �0       �           0    0    admin_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.admin_id_seq', 1, true);
          public               postgres    false    218            �           0    0    participantes_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.participantes_id_seq', 5, true);
          public               postgres    false    225            �           0    0    preguntas_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.preguntas_id_seq', 30, true);
          public               postgres    false    221            �           0    0    respuestas_id_respuesta_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.respuestas_id_respuesta_seq', 1, false);
          public               postgres    false    227            �           0    0    tema_id_tema_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.tema_id_tema_seq', 12, true);
          public               postgres    false    226            �           0    0    tipo_pregunta_id_tipo_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.tipo_pregunta_id_tipo_seq', 1, false);
          public               postgres    false    228            D           2606    32922    tema Tema_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.tema
    ADD CONSTRAINT "Tema_pkey" PRIMARY KEY (id_tema);
 :   ALTER TABLE ONLY public.tema DROP CONSTRAINT "Tema_pkey";
       public                 postgres    false    223            <           2606    32924    admin admin_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public                 postgres    false    217            >           2606    32926    participantes participante_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.participantes
    ADD CONSTRAINT participante_pkey PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.participantes DROP CONSTRAINT participante_pkey;
       public                 postgres    false    219            @           2606    32928    preguntas preguntas_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT preguntas_pkey PRIMARY KEY (id_pregunta);
 B   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT preguntas_pkey;
       public                 postgres    false    220            B           2606    32930    respuestas respuestas_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.respuestas
    ADD CONSTRAINT respuestas_pkey PRIMARY KEY (id_respuesta);
 D   ALTER TABLE ONLY public.respuestas DROP CONSTRAINT respuestas_pkey;
       public                 postgres    false    222            F           2606    32932     tipo_pregunta tipo_pregunta_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tipo_pregunta
    ADD CONSTRAINT tipo_pregunta_pkey PRIMARY KEY (id_tipo);
 J   ALTER TABLE ONLY public.tipo_pregunta DROP CONSTRAINT tipo_pregunta_pkey;
       public                 postgres    false    224            I           2606    32933 !   respuestas fk_respuestas_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestas
    ADD CONSTRAINT fk_respuestas_pregunta FOREIGN KEY (id_pregunta) REFERENCES public.preguntas(id_pregunta) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.respuestas DROP CONSTRAINT fk_respuestas_pregunta;
       public               postgres    false    4672    222    220            G           2606    32938    preguntas fk_tema_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tema_pregunta FOREIGN KEY (id_tema) REFERENCES public.tema(id_tema) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 D   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tema_pregunta;
       public               postgres    false    223    4676    220            H           2606    32943 "   preguntas fk_tipopregunta_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tipopregunta_pregunta FOREIGN KEY (id_tipopregunta) REFERENCES public.tipo_pregunta(id_tipo) NOT VALID;
 L   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tipopregunta_pregunta;
       public               postgres    false    224    220    4678            �      x�3�L�I��,H�K������� 8c      �   (   x�3����ITH+�T��O�L�LNL��4�2�!���� �O�      �   b  x�uT�n�0���歈�2h��(�!(�u��h�$�JR@ۿ��S>�@�c=��DI�ɐt��y\zU]wd���XX���,���o\��U�j1[W���8㓨�;֢�_��n/V���|W� l��Q�EYk0���}�;��w�v��-�ct��{Ș_�G0#t�(�4�`�૩f�&�ϲ��<��t/.��ƴ�)�6�N���0�Y���(v��E��ĖP�Y(:Z�㧥@���J2~p��G+-��r�A<�r��8��A>kj9QV��Q+~T�����{�n&FG�m-y�(��0�ŕ���"������ugB+��9|�U�L�L�;�(EɁ5�s671!Ш>yH��j�yۢ1q��
���b�댻�_��a�o<����!�	i�ϏtB	�~R47,�����?%�b�e%��)<����=����ag~��)Z��A��zY��}��?_��A�C��
�ۮ?���$��/�����u�p֬����5���L,rqWbi <4��������:`Mš�z;���%Ah���N�C\�b�u��6�g��3�ɸ�J
t�a*�ѱ�����,Y�����qw���#1`"�?
���l�CI�h      �     x�MT�r�F<�_�"����e9e��R��e.ȍ�]ft%���:�CJ7_���C@���鞙�lO/
�����T���A�aU���v���k����>����/[e,��Lf�^�Z@%	}�'<OI���ح�+�(iʆ*��W3����1.�OƸ�^;����]�9����z�ZΨia�V�ˣ��	=hl薝��=�-�x�[ϧL:����W����Hc�6<����G�n-5��4='�C�0fВ�3�ٜ��Bs��ޅ����pnIo���U~�B���+�q�a"j�SF�	5��y���ϋ �EYBs����&F"��¾�����i5a?8*��{�\���I�2C��M|c��)Q����u�[���DWtg��x��Y�o��ᄐk��/<�\Fw�������^�h�S
�:�Y#����I�x'|��Ԕ�c"
ٻ���yI����@��{e�~B��r����'���F��������EEB�?�3)����xn$2z^z8*�9]��\AK�v<��>+3�F��qJj��EM��aн@`�����.*g����8�h%n-�IH�\yn"~��D�\f�p��TlY�������FEE����?�v$jz�ش����{ձ��8o��6��}&ߔ��q�Lဃ=����v�2�Q�����Y�$��r���=��Bu�ɏ	�4��;��KX���<�nw&�ox�G�n��3�a���2JE�:��g��9Ʒ�~���LEݺ��RQ���1��8�Ms9;��΍�E��~i      �   c   x��=
�0@�99�'�w�"*x�P���Xooq��;o���N�K��<gx�����#�
+^����X88�na�;��#��ɡ�G�)"~!��      �   !   x�3�t,(ʯ��ML����2��/ 3b���� ��     