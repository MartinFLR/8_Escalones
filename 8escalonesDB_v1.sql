PGDMP                  	    |            8_escalones    17.0    17.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16473    8_escalones    DATABASE     �   CREATE DATABASE "8_escalones" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Argentina.utf8';
    DROP DATABASE "8_escalones";
                     postgres    false            �            1259    16493    participantes    TABLE     t   CREATE TABLE public.participantes (
    id integer NOT NULL,
    nombre text NOT NULL,
    edad integer NOT NULL
);
 !   DROP TABLE public.participantes;
       public         heap r       postgres    false            �            1259    16501    participante_id_seq    SEQUENCE     �   ALTER TABLE public.participantes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.participante_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    219            �            1259    16474 	   preguntas    TABLE       CREATE TABLE public.preguntas (
    id integer NOT NULL,
    pregunta text NOT NULL,
    opcion_a text NOT NULL,
    opcion_b text NOT NULL,
    opcion_c text NOT NULL,
    opcion_d text NOT NULL,
    respuesta_correcta text NOT NULL,
    id_tema integer NOT NULL
);
    DROP TABLE public.preguntas;
       public         heap r       postgres    false            �            1259    16500    preguntas_id_seq    SEQUENCE     �   ALTER TABLE public.preguntas ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.preguntas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    217            �            1259    16481    tema    TABLE     P   CREATE TABLE public.tema (
    id integer NOT NULL,
    nombre text NOT NULL
);
    DROP TABLE public.tema;
       public         heap r       postgres    false            �          0    16493    participantes 
   TABLE DATA           9   COPY public.participantes (id, nombre, edad) FROM stdin;
    public               postgres    false    219   �       �          0    16474 	   preguntas 
   TABLE DATA           v   COPY public.preguntas (id, pregunta, opcion_a, opcion_b, opcion_c, opcion_d, respuesta_correcta, id_tema) FROM stdin;
    public               postgres    false    217   �       �          0    16481    tema 
   TABLE DATA           *   COPY public.tema (id, nombre) FROM stdin;
    public               postgres    false    218   �       �           0    0    participante_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.participante_id_seq', 8, true);
          public               postgres    false    221            �           0    0    preguntas_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.preguntas_id_seq', 23, true);
          public               postgres    false    220            -           2606    16487    tema Tema_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tema
    ADD CONSTRAINT "Tema_pkey" PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tema DROP CONSTRAINT "Tema_pkey";
       public                 postgres    false    218            /           2606    16499    participantes participante_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.participantes
    ADD CONSTRAINT participante_pkey PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.participantes DROP CONSTRAINT participante_pkey;
       public                 postgres    false    219            +           2606    16480    preguntas preguntas_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT preguntas_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT preguntas_pkey;
       public                 postgres    false    217            0           2606    16488    preguntas fk_tema_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tema_pregunta FOREIGN KEY (id_tema) REFERENCES public.tema(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 D   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tema_pregunta;
       public               postgres    false    4653    218    217            �   Y   x�%�;� 뷇1�Gm���6��H�_��d&3��B+���a�؄�%����|�Ў�15�m��%fC�E���}>B�      �   �  x�uU�R�H>��bnܶV�srC .H���JU.m�ewMkgF�,ﴇ}���~#"�P��4#�S?��7����hي:IX�l����\S�67ڒYP�hN98��EY<#��AԶ���J��l��Z'f�ңz��85�ɯRds-�N6�eqh��8ܲOj�꥕Jm�y�Fi����\�L�%;Qs)u�{�Q�a��[�s0���:�(`km�{��U���<9<�'�;*��vy\�2T�U�%X����1��qM5���e�_P�~��^�h�V��H���4�y���LC�G
�9kw� ߕ�HoA'cɵ�L+���i(f,{r�44�}��0�TI��,��ǰ5w(��.P�Ǩ�n��D�'�a���X�S_qLjfAPiz��W��`l���I�<R�O�r�ġ�@�I���~b>~�����$m�<�.uN��|�nQ�nm�$���\#u�J"��{A�>�o�텮�`�D����+ƽ!#�ͷ��9��`���� ��F�̩Sp��ޙ?�_��5�"���]A�����,�y�'\�Bf�ԉF��x��hs	0����DPZe�*m��?]����.���Ĉ"��`���q�1_��|���Щ]�-.NҜ�ͷBX��5�޵�/nV�Ey4�,_����F����|�z0����9SL󙽹�%j߬��x���2A^�Q�]#��;��Zi8���|@;=���Ӡ���O���2B���n��Fl���ܘ?�}�?,v_t�Ԃ�:(�F_u�{�r�m�$�<v��?4�4В��@,ǈ[�2����;n0����
��9�ֱ'3�@���O��3@�Яa��ꂇQ��"j\%�a
��Ԣ}���ɋ���@����vZS��q��7&�7c;��P�1���l�e��t�>`�z4����81B�;����ܮ�%���^�ks@טK]��N�>N1/:ǯn=*��V���cnj      �   c   x��=
�0@�99�'�w�"*x�P���Xooq��F'��΄9v�F�ipɛ����г�r�V�`��Yü�\tc���-L|�x�)"~ ��     