PGDMP  +    $            
    |            8_escalones    17.0    17.0 %    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16717    8_escalones    DATABASE     �   CREATE DATABASE "8_escalones" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Latin America.1252';
    DROP DATABASE "8_escalones";
                     postgres    false            �            1259    16779    admin    TABLE     q   CREATE TABLE public.admin (
    id integer NOT NULL,
    usuario text NOT NULL,
    contrasenia text NOT NULL
);
    DROP TABLE public.admin;
       public         heap r       postgres    false            �            1259    16778    admin_id_seq    SEQUENCE     �   ALTER TABLE public.admin ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1
);
            public               postgres    false    228            �            1259    16719    participantes    TABLE     t   CREATE TABLE public.participantes (
    id integer NOT NULL,
    nombre text NOT NULL,
    veces_ganadas integer
);
 !   DROP TABLE public.participantes;
       public         heap r       postgres    false            �            1259    16718    participantes_id_seq    SEQUENCE     �   ALTER TABLE public.participantes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.participantes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);
            public               postgres    false    218            �            1259    16743 	   preguntas    TABLE     �   CREATE TABLE public.preguntas (
    id_pregunta integer NOT NULL,
    pregunta text NOT NULL,
    id_tema integer NOT NULL,
    id_tipopregunta integer
);
    DROP TABLE public.preguntas;
       public         heap r       postgres    false            �            1259    16742    preguntas_id_pregunta_seq    SEQUENCE     �   ALTER TABLE public.preguntas ALTER COLUMN id_pregunta ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.preguntas_id_pregunta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1
);
            public               postgres    false    224            �            1259    16761 
   respuestas    TABLE     �   CREATE TABLE public.respuestas (
    id_respuesta integer NOT NULL,
    respuesta text,
    id_pregunta integer,
    respuesta_correcta boolean
);
    DROP TABLE public.respuestas;
       public         heap r       postgres    false            �            1259    16760    respuestas_id_respuesta_seq    SEQUENCE     �   ALTER TABLE public.respuestas ALTER COLUMN id_respuesta ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.respuestas_id_respuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);
            public               postgres    false    226            �            1259    16727    tema    TABLE     Z   CREATE TABLE public.tema (
    id_tema integer NOT NULL,
    nombre_tema text NOT NULL
);
    DROP TABLE public.tema;
       public         heap r       postgres    false            �            1259    16726    tema_id_tema_seq    SEQUENCE     �   ALTER TABLE public.tema ALTER COLUMN id_tema ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tema_id_tema_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);
            public               postgres    false    220            �            1259    16735    tipo_pregunta    TABLE     i   CREATE TABLE public.tipo_pregunta (
    id_tipo integer NOT NULL,
    tipo_pregunta character varying
);
 !   DROP TABLE public.tipo_pregunta;
       public         heap r       postgres    false            �            1259    16734    tipo_pregunta_id_tipo_seq    SEQUENCE     �   ALTER TABLE public.tipo_pregunta ALTER COLUMN id_tipo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tipo_pregunta_id_tipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 11111
    CACHE 1
);
            public               postgres    false    222            �          0    16779    admin 
   TABLE DATA           9   COPY public.admin (id, usuario, contrasenia) FROM stdin;
    public               postgres    false    228   �)       �          0    16719    participantes 
   TABLE DATA           B   COPY public.participantes (id, nombre, veces_ganadas) FROM stdin;
    public               postgres    false    218   �)       �          0    16743 	   preguntas 
   TABLE DATA           T   COPY public.preguntas (id_pregunta, pregunta, id_tema, id_tipopregunta) FROM stdin;
    public               postgres    false    224   *       �          0    16761 
   respuestas 
   TABLE DATA           ^   COPY public.respuestas (id_respuesta, respuesta, id_pregunta, respuesta_correcta) FROM stdin;
    public               postgres    false    226   �@       �          0    16727    tema 
   TABLE DATA           4   COPY public.tema (id_tema, nombre_tema) FROM stdin;
    public               postgres    false    220   3[       �          0    16735    tipo_pregunta 
   TABLE DATA           ?   COPY public.tipo_pregunta (id_tipo, tipo_pregunta) FROM stdin;
    public               postgres    false    222   �[       �           0    0    admin_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.admin_id_seq', 1, true);
          public               postgres    false    227            �           0    0    participantes_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.participantes_id_seq', 1, false);
          public               postgres    false    217            �           0    0    preguntas_id_pregunta_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.preguntas_id_pregunta_seq', 320, true);
          public               postgres    false    223            �           0    0    respuestas_id_respuesta_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.respuestas_id_respuesta_seq', 800, true);
          public               postgres    false    225            �           0    0    tema_id_tema_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tema_id_tema_seq', 8, true);
          public               postgres    false    219            �           0    0    tipo_pregunta_id_tipo_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.tipo_pregunta_id_tipo_seq', 2, true);
          public               postgres    false    221            E           2606    16785    admin admin_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public                 postgres    false    228            ;           2606    16725     participantes participantes_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.participantes
    ADD CONSTRAINT participantes_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.participantes DROP CONSTRAINT participantes_pkey;
       public                 postgres    false    218            A           2606    16749    preguntas preguntas_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT preguntas_pkey PRIMARY KEY (id_pregunta);
 B   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT preguntas_pkey;
       public                 postgres    false    224            C           2606    16767    respuestas respuestas_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.respuestas
    ADD CONSTRAINT respuestas_pkey PRIMARY KEY (id_respuesta);
 D   ALTER TABLE ONLY public.respuestas DROP CONSTRAINT respuestas_pkey;
       public                 postgres    false    226            =           2606    16733    tema tema_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.tema
    ADD CONSTRAINT tema_pkey PRIMARY KEY (id_tema);
 8   ALTER TABLE ONLY public.tema DROP CONSTRAINT tema_pkey;
       public                 postgres    false    220            ?           2606    16741     tipo_pregunta tipo_pregunta_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tipo_pregunta
    ADD CONSTRAINT tipo_pregunta_pkey PRIMARY KEY (id_tipo);
 J   ALTER TABLE ONLY public.tipo_pregunta DROP CONSTRAINT tipo_pregunta_pkey;
       public                 postgres    false    222            H           2606    16768 !   respuestas fk_respuestas_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestas
    ADD CONSTRAINT fk_respuestas_pregunta FOREIGN KEY (id_pregunta) REFERENCES public.preguntas(id_pregunta) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.respuestas DROP CONSTRAINT fk_respuestas_pregunta;
       public               postgres    false    224    4673    226            F           2606    16750    preguntas fk_tema_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tema_pregunta FOREIGN KEY (id_tema) REFERENCES public.tema(id_tema) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tema_pregunta;
       public               postgres    false    224    4669    220            G           2606    16773 "   preguntas fk_tipopregunta_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tipopregunta_pregunta FOREIGN KEY (id_tipopregunta) REFERENCES public.tipo_pregunta(id_tipo) NOT VALID;
 L   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tipopregunta_pregunta;
       public               postgres    false    224    222    4671            �      x�3�L�I��LL�������� 16�      �      x������ � �      �      x��\�n9�]�_0@5S�|)3WI�\�.�j�]��3��I)"͈H[�ͧ��/��f���syI�3�)4P�r򒼯s_��������g��d���F㿽���_�{�D��T�F�:J�Q.�U��k&�����K�Q�ʈ�T2�Qi@���.xմ�m""#_���k#�"Z�ht�+g��͢�ь9�'�;8QF"���`޹�^$��޷*2r���č"��u�R�Hw�Ews�S��_2+2+�8:�����E�5ħc�����/�*!�tf�ѩ?W�Z�Jsaܒ��LnE��~�q[Ns�p�~�9�+��ĭ���X@��Ӭ#ʵ^%Ҫ�)ct�&�Fk�WkCZFz�ͻ��*4D�>|ݪ�s��&�I	BkO~��6Zv�q�{4v��v���߈��S�x�56��=���r0~=���JJZ��&���-��e=�������!��K�f�ݴ�A�?V*�4���i�4JeɱX���(-�f=Mz����MRR��t�V._:���������a�Jf0ov>�:���r��d<pS�M�cݤ#��6��/
�]O�����+I�v��4m�đ��g,�=�s�j�΢��A��v�Դ>o�Ӟ�X
A3��د�1�+#R�Tze�2֍),E��$�����2�&&����;|3[�u�ӕ��"�B�2cF��u���a�f�rˡ��#E�I"3�ϚL`EFrFif�o4���5+e�
Ge��q��Q���z}n4�푱HW��A�{�k/����ʤ��v"�B�7�W�S��5]a�f�qL���*& Ɵ�Z�t���>��r�1'�L�VA���+ �#��f��\g0?I)D��٣���f�U�1��WA���C�"�,A|��T`�4"+ J��������9�� �[S5-�&�ӭ!<��N��ـ�B�:&���6�u���'�YpvXJ)qfU�إ�+�L
�U$7�6��6��C'�/11�<D*�h�"��e?|)���Z|�"E�R�&_���v�\�ǲkd���6�*d���
��t��n��=��|4�#�w�z��V�RQ8V�Z�E*�i7))K C�\+��ݓ���R&��,W��g5�h��c⣒H�p
27l����gu#nd$E3�s'�5�\;�i� x�N<9�򦁔HGC�v[$�h0�Å�2r�z����#�?�r��͛K��*��M�'/hG�h#�K�0k�ci�&�]�u�Fr�F4H;��鰚����x�Q�Z�1��d���%��Ed�ҙ�g>�%��	96�����zvg�E|�����(��h[&!P��;oYD��Gό��ـ��X�JJ�9�gM
g!��^e��t�p�-�X+��ƭت;�0_�*c�Vr@z�\筊�j��L���5�
UQ��[�6�'A��7��tf��LD���d�eߢ����X��P�G*����5X�V�?��;.q���5���N�$Y��t+�5�D�B����cc���������z[�0{�(.��.!�H�����.JS���^�~'�Y�ڪ���npV�;�c)H�2����a���Z���EÆs�X��k��^X����h��zb�̞��;Dפ���
�WT�Z�wr$�E[��FM$9MVŉ�s ����]��5����ƹ��9"Rt�>�~����N)�f�[y�5�f*(f9�W�0Y�9n��d	���ә#�P/���O�vu��['�FD��G��ґ��C�F��F'WHU�W$d�ĭ<��2�-a�,,X��
"��b�ʺ�J�غ��Nʨ��Ie�j�]��nU�9�`�l��W�"_��jIDoY�7Y��*ঠ�u��o Q:,u�PJ����^nA>t��},i����@�XW�1ŚS�K�\tN+<�t�.I��H8���_"��F�l�#�)w�kc#6�_�B�㭹�".�����2�?:�C���,h����X�iؽ#���!9"0~B�'��I�����|����{�RH��3�m��gr\d� ����x4���]�S⼜~�3��1��UA�����~k�4h����=�<_�0���E���s"Aߐlψ2�.��N�H�ފl�S~u�l�L�~���e&RG5��̀K�������6:�n�vA�+S��m	�����c9a�U�+�	6ؤ��;L^�k����I)���(�Q\�
��� s�I��M��ݺ� � h\��F&�*T�L�z
�_xB�`����
��L�mY2uk��e1,A.�.Ps�p�^�m�����߽�]r��U��e�Ū"fY;u>�9��n������L�/����D6��J��H&
'���';���pD`����H�����PH��^!���6\O��ֻQ�����pϐf��i�,W �\0��Zd��[���u[�gW��JPާ�w�`��TZE�nڪS�����zL�͵����g*.3���H8��t:tf�!Z٪?��E�����.?E�m<.l���\�0iq��J���F�"	7���)z�Es{nU�9�l9� )��D�l��K��aV��Y�q����E��A��Ł�� ��	Mfq���'JR�-�Á-=?���e����y�(¬�☵�Q��-���r�t��n�_<��ĦB!��y*�u&�-gC4��3�wu�����jJԮv�jb����&!_.m`g�� u�l�D���}!�#��Cj�qqL����|��p\�?EO��V#�N���������ٞ����6�� �E�Q��R�8��p��Ӫ��[A�^�;�|F"^���7�V��v�YG��� l�~ٴ^V�m��%�HoN�P�do;o�_O��.ͺ6�K�w�#I�ڀ�ʦ��ȘtL��/����F{�څ��N�	ɘn~�n��v��Z9�45�pRe�jp��)�.�b�Q^���@�l�7���JظRT��֨R���I(+�� �@�;@D+98�:���b$� 7��W�$nm%�Vow�����4'�!y7Q�����߄�Q��c�E���3|��Ӟ� SG^��W%�p~mH�Ć�P�؆�+L,*A����5g6���yK�fR=Y����[�I$�^y�Z�?
R5�<5�X]&����L���"����Hg-:I�7V��t x�хN����W�$}�B��V�utCo\�cj��œ&8��"0��%"�
�@�!(!���U����a~͝��W�Ս���*��5��Ax�⏆�$����:��X�o�6�R�b9���8�]E~I"���B�4P�Ң��l�u�k�M�,�m�-[῅���%�^�[�hY���d�E�W��GHP�p��!c�w����tֵ'hiw��u���������Qz��ܞ�Ӟ��D:xJKa����,��>��OoD��ę}4~�*��7��D��ģ,r�]{�I�$;7�J�$��ޟk�H�&&����*p��yڍ0O8
�-����0���~��Y��w���$���#���h �� Nym�of�M���A�Da#AeÓ6a���q�Ol���w���1�I')y�%���S�-aoS��ht\#̶B>=�)�P!�<��Gw��gz�� M��œ��9��m��vħ'�M{��"e�T�j�х*���������I�O�&/~����މ'�D0��@6����~����S�(f1���н-V0����yY|�Fu\8vyT�ע*j��H�>0�VU�Z|\�KC���Ǣ�/�'����;�q^qI�K[ў4S4�W+����j���X9D�1�(6ڦQօZ�C}��[�2�B�01�7(��=ݼ�L~�}���-�qt�wp��Y����q��E�:ȻUϱ6��T*~�Y�&� �<OVҔUi֎��Г����	<`�����Qj����	��O^< �}�$�7��@��	�W���Tm��Lz�}�R�z�xy���e���z2����'a�nu�<�ľ=�)�k� �cm�����ѵ*���n�I��4�zF �  J�yn�t(���*��GyY����=�!�L�ʴ&�n�G�n�+J2�#�5�����6�!�}O��;��@�1���/��N-Sy��T�s8p.5�U�zs�p�I�9fK+�jZ_j+\b�QW�g�:����z\��<ǀ+\=�wۇ�C�QT���*�Y��t��*��U�o��Rw8�Oh��;·%b��W�~�Z*�ڮ�<�����?����FB�RZ��Oz�H�3ʡr�47n�@?^�|��jHz�b�����j��]i�J��R\�3}�A��_��-
�>tV�p���vC��!v��/q�w� ����ǖ��峠�Y�o��q���鼭
�b�B�)�]�Y���~Pk�?[�Ȭk�|z PnGf~�vf�{�qB�:H���ɉ�����R!�a�;ؚ���ş��H4�� �勆d;���Z�VsX�j4A��)�UV���� ��WȜ���#��h���e�a�7�-PPİ��������vk�%�F_�+l�SgoD3�(�P���,,�d�'ъ6�������"�a;���Tw�-�s��ͳc6�o���?��[H��k�����j�6��0z@�7ip�o��NX�o��(\��ǋ�2i�"_)�.�����-�J$��rm(A�t���B�^bǊW<3��H@݈��-�l?Au��y�|��=�X5v�)ߡ���o,���~�j48h����s��gi�ynl{\R�� �ۡߴ�if4b�����Y�Ԗ��y�[��Oz��o��Ԇ���9�	\��m���(6�޲��霽�i$�ѵ����$-�eY��( 2OQX��	|T�����`��][�H���c�{�ܲ���1捌�W���H�P�+�&�t�o6z9P�8u��Z\/�/�#���G;�I�P�-�;�,ľ�*�N>�$=|��i:�7Q����:;�[�^����������-�]ap�@S?���x^ߜ���+'w�{����7R�a�f��p�z_'�Җ�kY�]̈́����	}P=���,�
bAݤ�6�r侶]�nc�.�\!��$n�mv�� y�e[��irKS��2Σ�j�+#QZI|ȹ�b7Z��Ik���1���P" ���#Q�'�D�QM}I)��GCJjw�s3�7�7AU�i{�.�UZ����C�������0��c��~���O�@���Oo>���,`�����AX�o},֯]9l�d��%v����S�B"o8��nO�j�K�|�U[� ����.H!<S��KvxF/�����L�7�>�	����?Fb��&ێ_��e�k��jǻ��V�q�y��O�����^��v���O�8��I�-�����^�G�Wa��)��}�:n"��#:&hu����h���� >�	�z~C�j�3���W"~�g��Z��R�I3*�*�k�ފ������g�����f�B)����X��B�Y�s]ޫ�Zr0���VU��s�J=\O�|I��P�/��Q+��6pzk�$�I��J�+����zM�܏uA����R�ARS�:Ui��[��6�ڡ�A"�Iӧf:+�Pb� d��G���&½b���}�˶�Ez�ӹ
ҙ~W��lg[L��;���Kr�c-~�Hf�������~�^G�w��NdYt/W`������ú��+����%$R���v�	�Ƒ��؏qҞ#�o�4v��)��C#v�?g�*G���?�\>�! ��k.��_��pP���_�~��;��      �      x��[�r�H�=����uYb�ԾV�E���6���`"`a�D����_PG̦٘�nu���y��L��fʺE��ǂw���$&4ÃȤ�{� 6��&&�_R#���o��l&���<����.�+��4��&ex����[��ڐ��;��" Ř<�g��	{sQr� �����D|��W&��Qh�4<D���ě��MO����9�3>'x�l��t�|�������|�N�����/�'�>���6%�S��N��b�00]�������um��n��Z�.�n�@����jm;R1^驍�١�i'�du�m���gz��{�`xl����� U�=����i61����5'�ۅԏ$�
B�N���D�N�'�����\��r�v���l�ï�	�O��wޝZ����_soo�\�X87��z�&&K����#�L��D�1����/��%P�le�t~�څԷL�Em�b��DK�5zL��h�/�*f9�P�B�z,O�+��嫣	�T����&�ȼŖ~ٵ�B�ZcAT�<1�Ӑ�R�Ώ<����9�&�;N�%;FT�bŎ���XEĿϾ��/���w��SO�����D܂��G|���E\p��b�[��!�de��cNV��I�l%��Ĝ��NƜ��x�1'+s���ʂcƜ���C�c��7O�?>��/�o;ؐIBQ"��v�_} ���%湫+�L�׌�I"53����:
D77ol7�E�0�+�uvi���X���a�P�ٻ���S
����M'�\qd����׽ݵ�Pl�n0�|,����zi�X���킾"�?���uw??�yd(�7�c�4�a�_�-=R��ݺ���u�O�q���5���>�D��������Qc󶃟������<����#�ӥ摭7��\R�yz���h;O�q��e��ocw��c���ܚ"Ԕ*s<�B`��D��`�h�3!6��M�vط���kWm�+�Kf�^�^��Lܹ��~��g3�Zx����i�C��[�*��tt������q-��<����-)Z���bV���xd�L � �vC�~��gfbκ�en��	���٠ok`\*��yz3nj7q�#?r��׺�؅S9?��o�^۳�W�um�MۛT6�W;�����������y�yو�~o�v|4�L�KB���963��M{S�`��܇S���c�m�!��� R�
 ���7(��f��_:��5�U?���f?6^R� hac�n���V�9�j�z!��)�,���Ԝ��Ѥ� ��c58V�lw��p�&��,�Jx���Z�3�M ƞ�Cۣ� ��Iƈ ��ӪND�ƾlh�'��hu����-3�� a;�	pf���ԪFhڵ���dR{��b3��T2�
 Ыަj_��$��-f��"�)����3)q����T����	�&�QS�i��1��6	���鵉��ɵ���G�i���Q�f����3�V ����ZB�%���l!gȠU 3��r-�	-�	g��
ǱS����UD����GTˆ Y�y��6�����5�U�3D�ѳ���И��{fN�����W���YDj �Ƌ�fC���9�o��c�g�n�L��� �rf�T&p���[L�!��DK�	D�
���������l+8�"V�v ��Ӧf�cS>Tnh�~隝�q�p����Z(#?�*D�lS V�n�6����z��n.�GX�2�r' �K�������.����a۪;�@rB���}��t���[�)ѽG�0TM{]cve]�b.�-J��lp� s�0g����`]��o�������_�p&2I+���'r�X����Pb��U
F�O�i c=�Kͻ��&O͌+î)��j7�:8���������k�6���[�j���b����(sԕy��Ո�gRh���۹��/�f7��)eC ߳u����1h[��>�y�=탗��Է�����e�m��_h��l)�_��-e\������U,ԧ:��Z��c��>�R� �(ȣK��w�y�I�"����M[��LLwP�RV�&��gx78�FlvNﱡ�0�N/4�{|��ɨ�籂���؀A�
�O)s��M^��6Q��_7ד���ܥ�� ��E^L^���|+5���Δ������ٛv�H�C
d�p���O��|�6C�w](%XU�^�gw�����t���X�ޟpc�1�"�^R��x�v[`8�����O���v! z�,/ r����6B?U�W��m剔D
lq�5��B�<D�t*Vpc����Ά̸��kBLq�3~��46�+)Y����u�0�Jg��4��3Ec����k��(y�+mF��4�m"�R0�W�%�93m�G�)o��*tD�jp*ED��>>T�!*�%����M�� f��Zs�2%W�(��L����+��(a��9g{{����tRl����􇯞���!DC��I	��������/hp�pd��g*�"��p���#�4oZD���X�`BblثHV�B	�{bd^U��O�e����a���������n�/4N����H��{�r�	��1�]�L�0%@����e���htS/^�w��a�:�(��h! +���~���#�O�u��2�duG��2o��n&
�����H,Uns	�E�_5�^.�9�5WK f5�9|L��Lx=��$�u"��ݵ�C[]� �"N��|��gn;�)�Nt�z6��W|�͑�+A;V�H�9�9O�=�ς�m��ϴ����+���@���Uժ�� ��*d)��0�Bw	���b)5��7(�v"r����,U���m��π�EUۊ��"�w��Y&:j�L�o����5^ձ�i��.f�+�)�"�]:�{֮+5�/�+[S zglo=%Į�!vK7K��|g����q�}�Z��'Ȫ�kwl�G������)8UЋ��*L��<�,p�J�؈jwt���G��e��a���À��.x�~:�G"=�Hh��an���Z�T��A ��� r������t�X�����#��u���%��|�ة�ltV��@8$�I����P�Ƹ�חP�@�&�}���0�Z]L���
�F��"eq\[���zC�17�>Z���	U6�~��`�� "��/1 ��>�4."�i1,�f?�Ȯ��2�� ��+W! r	\��Xr_��NL*KO ���x��}%^���@�������g"|X;�tΰ�B�q��LM��2���3�@H�{�n��zj�/k�0�=&���N�p�k����<��)%�t��ae#T�!��<מB9��'B$e�Ş_f���GϏ>*KE) <_��e�~� ��0	��0	<���*!�j	`�C�ևo�(�����n�!k�	hnp�����K@M{�_ݚP咄x���n�b96���k<��n.}�<��R�m�=��:cw���vk��b���AT�I�h��C�O
 ��,�ѓ3ٯƻ������� x���?�5^& w_RYr}��z���ś� �Qb�7���P�������We)���mʧς�ͤ�<���=R����v���gS]*��9�����ep2g��v���������Lyļ\�~��*m%p9�:w*5w��ߛ�*a	��7�\Z'tb�3-���c"��<��ǵ�������3Q<��H�N�:���)����:���������� -���<�;O�K5���d��_��M"}���z��`��*ϤB
��a�N�SCS�0!��֘�0����������K�~���K�_o`���L���m�ֶS�8��%PP�2�OB�B��E�&Bq�Ϥ��1�� �0S&�*7&�U@�
�	�˂Y�
|I����t	q��~�*�%@V]�A0�,a¡*Y	���&�UBt-�iV��ϸZ��)�j3	Q��k1�U���N� X	��c$�+�*G$�����0��R&�Z`U95ג�)oO���)�L�˚������֏8����K{��k��\h�]w:?�݆��7��u���v�:ߖb��9����I� &
  �s��� ��i�����S;8/_hoG��B)��L7#VHR,�^�T=�j�u������_���"�C>��K,��Z�0��IN�c��f��t%���6Ȑo�c���sCg�Ӛ���2��e�a�������vSk��v����#�>҈ �h�$��V?�n`��#��̋uv���)>N�i<8�v�ፎ�P���s��j�?=�2^#��s���U�|ܵ���>�opRo�v�Og�x��q�~�=��JtH7�׎oD��Ƽ�4°!{=)�;�?��s����gm��9������i5��\g��"���I@��i���I���ؼK��#'5O�;~��7��m;q����!\| �i��'�*K)�����5���]��?)��!�TA?ێ�8 ���.x�0`o�m��\��'E;�&ҵ��X�Oxs<�Z$��%V �����{t�IW=됷x;n������^"���[;�P�n���F�&�L�����C�"�t%xW��ϖf5] ���K`GW�8O��g��l���-k���������4���}�D�z����S����͞,C����e{�qj�oɸ��j�'��ך(OO�T7�RD��O�ؼ���v#
��`� ������m"^8N(CCp𾭯�Y����3��� �FR
<��[�͕hq�=��%����r$�'k�}�ɽ��%!:�ض�����nNmd���.S��t�*����_jw����wX�ݑNq@��jZ(@ 4��򓯉T�L�Y�d�\Us���1�N?����"H����SU�tJ�1��_���&R�*e�]���JJ]��TIJpe*�*6g�7]m�x�Se�� ��J�B3��8�2�f�#S@��U��V�>�U�![)���䅹x�onr[�c��7B�=�J7�2`�+��g��X��]#��3��U����|�>pK�	`��6��`�D��d*ϫ�|!o).]�\1r���O��͜���9j���֞�9��i�E�\��f�;����; ?�u�/Z���d�N�����m�Ip �߆��1�s3%��G/? o�(�n$�B��������
=Y4]D�T�ɢ钞nBe��t��Ϲ4��U�<3���y���s�e�og�JFY��^<B|�[��v<�!`} xT���-M�ʾ�������ᗚQ��FeL�������V��o��ί�g�=��_���y�Pz/*��OY̨��05*9�ui����jkRS���c_�\(��9Ru,�yM���G��H�b�^�%!��'#�iᣃ�n�:�j�2lߏ퍽
j�LUߡ�K���1�\��tj��tg!E��T���Ϻ���Ǖ۵��^�kb��w�3��W��ͱ��sU��_�2#����S�[�+�̔���9ٮ�,e�����n�/]ÍTJ�2�b]����64#5)�G�S�`3�͒F��c0+�z>�cjL>dn��yU)���F`��Y��x��8쐪��<x����s�l����^}��)%�t)�����u���s �aT
�`��.3~95�*�Y!W�:b�}/��hU�2/�jW_���R\𢔶	�E�T),+y�?R9*+�[Ī0e%��G�e�F��Hl$��Z	�4?�D?�*k���k�Z��r-�_H�O���	13�H��\���x�"�E����:��V.���ފ�>����T�v�W�0�HxǢa�1ҹ��R��|�s� ڭ�8X8v�k��w�U�noK�
RN��Cg�w3��m�7w}�j�êN���?��5^,��Q���������g�س7S�m��U�$h�Gޜ�<#������H�+�����1|������n�v�������52����� 2z�_[��3���(?���ASC�4ʕ�::��/�"UZ�He�y�'�����`��@�4�{�Qۘ�g�T��γ�c3H&JyR����=��v��7݅���ڪ�a���Zd���?�&���ʵ!���m�t�(ڑ������R.����l@R��07+����9�e%a����&�sLcU��2�"Q��xY��93�v��gс~X�{q�K	��Nz3S��T�x��]��r��~��;�9�j୮��d%��WҾ�v�w�6g�r>8����sUa,杷c�� �{�[1�1՗t(O����6���v։��2ͥ��{E�H��8)�F���i��Gg�l5�G�fh���`�s�Hׁ����$R�.����&����V��GNk��h�}1ҕ�<���x}�>�CK������{�1<���H,%֍�<��5���]�L�~W�U��y��^���~�����[X��9�`:�I����UxjXȫn�T�D�c�}�L�ܭ�B�@'�rQ���<���H�>��l� ||��ރM�U���	�Rۂ?��U.̕��+e���_�r�+ �
j9<�:H�7k�_����~��R�3'�?��6y��Ī���	M�2I���&V�"g���*9��vbUr~|�M�R@Δ�����H��+�.���<�?~x����f�L�      �   Z   x��=
�0@�99�࿫(�`o�J�ZI���nox582~��6��^[�%Z��6�ҕ�ì�8�!�J��p���P�.��9+D���-      �   !   x�3��/H����2�t,(ʯ��Msc���� ���     