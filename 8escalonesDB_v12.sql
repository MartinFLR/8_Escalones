PGDMP      9            
    |            8_escalones    17.0    17.0 %    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16896    8_escalones    DATABASE     �   CREATE DATABASE "8_escalones" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Latin America.1252';
    DROP DATABASE "8_escalones";
                     postgres    false            �            1259    16897    admin    TABLE     q   CREATE TABLE public.admin (
    id integer NOT NULL,
    usuario text NOT NULL,
    contrasenia text NOT NULL
);
    DROP TABLE public.admin;
       public         heap r       postgres    false            �            1259    16902    admin_id_seq    SEQUENCE     �   ALTER TABLE public.admin ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1
);
            public               postgres    false    217            �            1259    16903    participantes    TABLE     t   CREATE TABLE public.participantes (
    id integer NOT NULL,
    nombre text NOT NULL,
    veces_ganadas integer
);
 !   DROP TABLE public.participantes;
       public         heap r       postgres    false            �            1259    16908    participantes_id_seq    SEQUENCE     �   ALTER TABLE public.participantes ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.participantes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);
            public               postgres    false    219            �            1259    16909 	   preguntas    TABLE     �   CREATE TABLE public.preguntas (
    id_pregunta integer NOT NULL,
    pregunta text NOT NULL,
    id_tema integer NOT NULL,
    id_tipopregunta integer
);
    DROP TABLE public.preguntas;
       public         heap r       postgres    false            �            1259    16914    preguntas_id_pregunta_seq    SEQUENCE     �   ALTER TABLE public.preguntas ALTER COLUMN id_pregunta ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.preguntas_id_pregunta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1
);
            public               postgres    false    221            �            1259    16915 
   respuestas    TABLE     �   CREATE TABLE public.respuestas (
    id_respuesta integer NOT NULL,
    respuesta text,
    id_pregunta integer,
    respuesta_correcta boolean
);
    DROP TABLE public.respuestas;
       public         heap r       postgres    false            �            1259    16920    respuestas_id_respuesta_seq    SEQUENCE     �   ALTER TABLE public.respuestas ALTER COLUMN id_respuesta ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.respuestas_id_respuesta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);
            public               postgres    false    223            �            1259    16921    tema    TABLE     Z   CREATE TABLE public.tema (
    id_tema integer NOT NULL,
    nombre_tema text NOT NULL
);
    DROP TABLE public.tema;
       public         heap r       postgres    false            �            1259    16926    tema_id_tema_seq    SEQUENCE     �   ALTER TABLE public.tema ALTER COLUMN id_tema ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tema_id_tema_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 100000
    CACHE 1
);
            public               postgres    false    225            �            1259    16927    tipo_pregunta    TABLE     i   CREATE TABLE public.tipo_pregunta (
    id_tipo integer NOT NULL,
    tipo_pregunta character varying
);
 !   DROP TABLE public.tipo_pregunta;
       public         heap r       postgres    false            �            1259    16932    tipo_pregunta_id_tipo_seq    SEQUENCE     �   ALTER TABLE public.tipo_pregunta ALTER COLUMN id_tipo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tipo_pregunta_id_tipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 11111
    CACHE 1
);
            public               postgres    false    227            �          0    16897    admin 
   TABLE DATA           9   COPY public.admin (id, usuario, contrasenia) FROM stdin;
    public               postgres    false    217   �)       �          0    16903    participantes 
   TABLE DATA           B   COPY public.participantes (id, nombre, veces_ganadas) FROM stdin;
    public               postgres    false    219   �)       �          0    16909 	   preguntas 
   TABLE DATA           T   COPY public.preguntas (id_pregunta, pregunta, id_tema, id_tipopregunta) FROM stdin;
    public               postgres    false    221   *       �          0    16915 
   respuestas 
   TABLE DATA           ^   COPY public.respuestas (id_respuesta, respuesta, id_pregunta, respuesta_correcta) FROM stdin;
    public               postgres    false    223   �N       �          0    16921    tema 
   TABLE DATA           4   COPY public.tema (id_tema, nombre_tema) FROM stdin;
    public               postgres    false    225   ��       �          0    16927    tipo_pregunta 
   TABLE DATA           ?   COPY public.tipo_pregunta (id_tipo, tipo_pregunta) FROM stdin;
    public               postgres    false    227   $�       �           0    0    admin_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.admin_id_seq', 1, true);
          public               postgres    false    218            �           0    0    participantes_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.participantes_id_seq', 1, false);
          public               postgres    false    220            �           0    0    preguntas_id_pregunta_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.preguntas_id_pregunta_seq', 520, true);
          public               postgres    false    222            �           0    0    respuestas_id_respuesta_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.respuestas_id_respuesta_seq', 1645, true);
          public               postgres    false    224            �           0    0    tema_id_tema_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tema_id_tema_seq', 9, true);
          public               postgres    false    226            �           0    0    tipo_pregunta_id_tipo_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.tipo_pregunta_id_tipo_seq', 2, true);
          public               postgres    false    228            ;           2606    16934    admin admin_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public                 postgres    false    217            =           2606    16936     participantes participantes_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.participantes
    ADD CONSTRAINT participantes_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.participantes DROP CONSTRAINT participantes_pkey;
       public                 postgres    false    219            ?           2606    16938    preguntas preguntas_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT preguntas_pkey PRIMARY KEY (id_pregunta);
 B   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT preguntas_pkey;
       public                 postgres    false    221            A           2606    16940    respuestas respuestas_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.respuestas
    ADD CONSTRAINT respuestas_pkey PRIMARY KEY (id_respuesta);
 D   ALTER TABLE ONLY public.respuestas DROP CONSTRAINT respuestas_pkey;
       public                 postgres    false    223            C           2606    16942    tema tema_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.tema
    ADD CONSTRAINT tema_pkey PRIMARY KEY (id_tema);
 8   ALTER TABLE ONLY public.tema DROP CONSTRAINT tema_pkey;
       public                 postgres    false    225            E           2606    16944     tipo_pregunta tipo_pregunta_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tipo_pregunta
    ADD CONSTRAINT tipo_pregunta_pkey PRIMARY KEY (id_tipo);
 J   ALTER TABLE ONLY public.tipo_pregunta DROP CONSTRAINT tipo_pregunta_pkey;
       public                 postgres    false    227            H           2606    16945 !   respuestas fk_respuestas_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestas
    ADD CONSTRAINT fk_respuestas_pregunta FOREIGN KEY (id_pregunta) REFERENCES public.preguntas(id_pregunta) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.respuestas DROP CONSTRAINT fk_respuestas_pregunta;
       public               postgres    false    221    223    4671            F           2606    16950    preguntas fk_tema_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tema_pregunta FOREIGN KEY (id_tema) REFERENCES public.tema(id_tema) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tema_pregunta;
       public               postgres    false    4675    225    221            G           2606    16955 "   preguntas fk_tipopregunta_pregunta    FK CONSTRAINT     �   ALTER TABLE ONLY public.preguntas
    ADD CONSTRAINT fk_tipopregunta_pregunta FOREIGN KEY (id_tipopregunta) REFERENCES public.tipo_pregunta(id_tipo) NOT VALID;
 L   ALTER TABLE ONLY public.preguntas DROP CONSTRAINT fk_tipopregunta_pregunta;
       public               postgres    false    4677    221    227            �      x�3�LL��̃�\1z\\\ 8Z      �      x������ � �      �      x��]͎Ir>�<E�Ok�7��f�d�Z���Z#K��6�K��M�T��dUQ�>��~�0G���m.�7����̬�R3X`GRgDfFD�T�&_����Ss���U�9]�S[[e;�TV٥�{�7����j���"���Ե�t��"�~��\�\�6SE��` �ݚ~��ۥfU���tI�y���f�f�p k��t�J�jlؔ*[��Х�/�K`E�s])g�\�Pٽ�mu�Tֺ2��������f�ΊBmf�,�y�\m�F6_7*S�^�l �<�5�v8�F�:��Ѵ��^��:�6�O�ܖ���:F���	s�t���%K/��{�yT��F� #f
�*�7�^�:��o�ï��dn�;[j�	�0env�oe��0}�`�>|RD�=oJQ.�䇏E���N�H	������"�<�l��kפ�s��� ��[����Y�mnVDy`�W�g��[O�˫ I�5�l*!�vz�H�)M�N�-=�V:lq��ӥ!�{���޺����s��⇏5�x��/I�*����+�5�.��q,�Bvo���`�+�o�}b_���}�~�hw��ek�*�|��
[U��\u�X��;<��q,&[�2"��')X;ExouQ��ou��U�x�ˉo���OF;G̭������S��
!��yMvV������ ��lԃ�XA4*<^�aH�n ��0��np����k=z���C�}_x��l��0��L�o�w
����)�
TPn�R2��e���	tA�֩���I�����yK��O 4I����V�N68�Z�se�얶���_����Ze{������W�����n���y؎H��G���#9�j+�U1�/G��[��2�mi� q�Bx	��.���磂3�H�ʐ�NN%R�������.[k1H��u���s�ԅ��f��VM�8���>O����'�S��bp-��9|$�V�%;h��f{��XCN�V����J9:q�U8��t�זE���jE���vIѬP��t&��:�"x}�u�ǽ>�D��Z�D����3���ٛ��<�h�r8R�y����j����q�_�z����͎�#�j�]`�c���i������˕	��G�r/>I�vx�b����8�ʰ�uB�ʬ6��|�-_ú�[58�Q��vg���.�Y�Ì�L9z4e�Z9��W�,�ۻ������H��gK'}�%r�y�v�>ӳ�Y��R�Ș�E��6�Ȓ̉q�,�0t��]z�� ����AT&�����Er���������z��.�M�
�Y҉Ξ�Uq�_��3����a��xٸ��M$�|`��ԗ���dn7ʑG�T����P�_�;�o�����>�F�"_��C�b.��[!�]C��)79?O	]���*�ƥ�>j������k���rС.Id��	t�z��0=�J\�[��V�ٸ
�%r�c��_��-���D�T?�@(Rz��=wl�`~�
�gq�U��B�����'�v��'���G,F`y�]���v��N������Nh��9I�9Хw���6�@R*�^�(�1C�Cx��I�j��;�.�'�/��-=J췣G���[_7������|+7ho�!�7�B�"��cM�KDυ|Bف��]@����}���Ƅ��I/վ����K��P�yC�~d�ȅ�D�µ�.�W�ʌ4�E*$�	�+����i2�UQ�`�d����n̴Xɶ���p�he,�k��ڌ<7�dX�J�����(�F㙹��E��Ѱ�����/夰���L�\��=�	4�j��w����vOs�x�h^
���ϒL�����MvvYİ�sd�i�֟�~P; ����J�
�D),�9g	2v�U��u��É<�g��o�b ��Q�"2�rd{��M�������FGd�q���Q�����x��fl�'V��,Ϡ�wj�R�1��U),y�?`c�~v�ާ'W��*�o��8`�譩�YiU�v�N����4'��1�H׶{�*(�,ú�#�9z�l� r��<��jo�de�2	@~�J�x��-��b�⎲7+ɧ��E<ћ�b��Nѳ��ڗC�c$Q����D��u�
׸�z�8D�:آ�� ��ġe)�ob�l�O����>�3%�8���r	�afM �e7�(ߒ��!���D�ᶔ�� ;*�k�E3u�U��T�c0,��ϻz���M�s�%%ڧv��򦠗�Ho�f�.�1�2[��Z��2���?E��;^�*��-_�"n��O��禛C"i����S���:M�(�o��IV��/	�*C��%�����o�Jۮm�K�o��9Gx!����GQC)ṇ��=��]�e�vY�k#���E"8�K�u)نp��*���x������n�s�dV�����߰;Nj��)T|Ѭޛu���=Ѻ��=i2���[�����W�L��p���Jnf�)�Wj�+#�TU�-�]r�7����b�R5��ڙچ���$��i-@ �`A� Q�J\ '=��0K9H(7��g�I��)�]oT["9|̩N�Mv��!g*�!��r
c`z�C/4d͑?#�� 1<u�U>|5.��.@��!�X~E��$�%0Z*< �?�K�7�t�a�Y4�� ��-h�b`޼e�᷊XMJ��H���%��y�Uv�KÚ�]��� �d�t�x��[T���@��Atx��P�<���ѝY7���o�F���r�½�x��["�A��҉�S%����j��j7�`~�y� �kUE�:͖k�$��#�����֍eb,֓*Z�qؠ��:���8�]�Y~M$"��B/-t�Z(@vܺD�t�1=�.�����=K@�,��D�Ѳ�x���]~ձ{�	*ΰ�a�0��kMg^�w�������ʃ��x=�li��}k<΋��=Ez���&f;�FOm��_��:T�T�o�������W]� ��+���l�;]�(w@��N\7ij�$�q��'C4U�H'ǽ�/��t�;��^�~�����?��oopջA0sJ�����L�rI��<j�_I#��SY��\vhMe��;E�DŖ�a�d]D-8oGxr����������l���� ����񔐷Y�;��ȏn����p)���{�4�8�4��g�v���'	W���9
�Q�t��d6��Q*��I�u��2UDq��5W\�8A�Y����W�O�Z=@MDA��{��G��7��?ܩxg�f	��1�s�����Y������mG��\5U+|�#�k7,�eS�Ԅl��4��U����?�ʡO.���,�M#!�,�X{�L���e
-��Ͳ09]�� �^�yI���Fe_-����W�V-�!ӫ\Nn��8��� 7O/�;��6m��8��z��\���Vkh�X�2{e#�;��aJ�X�2�;]Vj:0��7�R��j�ĵ��%|�L�;��C��2j��:�ѽ����'w�����^� 8ӑd�'��&'1��Yљ���JEv��м|u��C���G�B��;�`�^�~���A�1l$��4��o�79���~\S�*�w	�������gc�_����~�����!Pa6PT�҅^�N%ٗ������%9s�#��U^|�u����-��]P+Ԙ����On����m�9�OlԿ4>z����$���JP��C��w������_�<�UҶ+M�y�>p��>�DQ�k�-�m�Z��S�) V��^1x�Fz����p����`��S��PWb��R�5��C �������(�Y8�[r��}F�A4
�E�|��X�;_s�>��y`l'!�
\Mͅ��b�\��j80�r�����7�Щ2�(�E�ÖW�?��_�]�`�Y�c� �??z�pX�X�����-�'Z��.Ȫ�&�)�����bQ+i$$� ֪i[
�e_he�<�����g4h�8��b�s��Y��C����a��5U����/Ua��^Gr-N
g8���� I�Q'C    �k�:r�jL]�h�7<��}4��d�1�:�Q]{u\YnR�V�/Ia�K�Z�Wa-��)���F0�1ō�}bA]�VP[�0U�mm]qr~�S��Tj{x+nWi�yuLf�G{D���z��x�&��e��/��u��0j�H:�����R'v&��+��*؋!3����>�:���z�\�jYh��Po�ʑ��p�Nk�ؙm����ԌY3��N,��xv[P�@���oel,�o�B����h��u�T���@�J|�������s�%�j^�9H��fI%�VQv�;K��Ro\Т����V��j]Z�ⴖo�mk�G��x��䶏���k�1{�q>�HG�
���* ʝ�U�$�A�`����ͨ�$��hdg���<��ܑ���c�w:�\a�"yA���Hz�Z@69m���zew���5���~'BZ�I�;�vI�P�,P�HH��fg?m45���Pu��g5�����,���V]U�������r8Y�i�fi�A��i��;0JqW�^[D���͟j������7p�x����5�KW��b�Z cd���A�Ptj9� V�M�8Y'�ב�+�B�˸0��E�!q+Xqv���f��PR�-�@�N�[�*�q��4�M���)��NR,�h3'��^�r��9O�DW� )p�(œy����>nɰF��1&u3��nF�F�	j� ��RzViٺ�	'E�TN���Q0�c�>qAy`/����w�d���f��T�`F�>��W>v�2^�
��>�����b�(/G���ӣX�6_�ٖH�Ѫk��E*�6�\��u0��ͩMN���p"ey�'���I^7Lv~��+b���ڇ��R�����Uv�o�8��A鵠�I��%����l������_�mMQ<���� q��wD�] �"��Kt�����J�#/�~.	�sp,�7�S���q7j�(T�/3`��~j��Uڙ���ޱ���H�u �f����	DV�������[51Ƭں��긖bZ�k�J�v:��r�dq��СV:y�c��x8�Zg����la�+&���o튺܏eAd���R�ARR�y�����k<�m49���A���nRwV? *�"�xq~1	�7�+�N??�+�Hz��;�3�")�lé	��;V�;�ܬ%��$����y�� #2�v��2{���$i�'Pmh>�K��yB���!y�U]��X9R<r�N{�0�a��wr�%���f���#��}��\��!�Į$�z~��VN�*�h{������s��>���]N/�ٲsp�Z͒�n��d o��
-&����v8����f��hH��C�P�&�N��bݸ]4��@9�#c��}w���;Nh�����A���*�j۔��,(��7 �����r�a�Ye�r6�����*�N���_o6��Z�2�ݺT���/M���Qh�����|=YÜ�3�Q�<���ٺ��m�t'�ȳ�!=]U�VI�1�N3W���9���C*!z�5�NW�R�NQe�� Ǎ�69�}��e�I��vT��t�A~
��9n>�\���z�k��+���~_�2�7�Z����,�,�	zj��*@1���S�tYǩ��j�׽o�,}�0�oh*����y�z=5h�����5Q+,�+��E��T�] ��L�,�������kXX�"7�m�a����Xh�-�`��U�.a��=��P�
n��D���Μڊ>� ��ý�PԦLXޔ����Y����*l����� �b,7.����@�4�^���{�
ޱ*)���P58>�F��$uS�{�k�G0���[2��1p"�f��({��_BTha2�Mί���(e+�3 e�u����~�\1�f���* \�3&}��M�*}���AE)m��r����<�<�Gb��meUgDx�~
C�}0�r�=7��?#���81;M�.~|�Y��ʓ�K��~����9��������Ñ��$$�Z��t��k&��"&���n�QF*-��b֣>��Ț��b��2�:��dj9
���r��ʊ�џu��wR|���|�����& �*�-��Z�d_� ���X��^�qW�f�����e↴��89t��
�tE��h����v	�'�8eN���$�Q��q���Hu)v �V�
!�z�]��Qv���8�>2�H ���8���d"��X�'?>�Y�g#I�}a˕�qU4-~�FF������\�o��Z������;^��u��e4|��S��E�{_��I�&�&��W��iA<��8yeZ�7k'��1��|_���Ps_����f�ԽH�U�`5��ᶵ!1�x��$�?k[�ۓD���(8��JM�y��������UAQ�*o�QA4V̴�rr��.��.uں0L�R#�ٮ��}|�Rx����V�x�{������8�6������	9]��W X`���M]P(}����@�S����垥O��0�d�-��D"��6� 5V��r����G/��v��Q���ǡ!��1�t��Q <�Ĝ^7<L��-d+x��2��nE���۽rڷ�O�۞��%[�R��������~9b�����Xb��F��>+�l��S;���2+�N��_P;n[x�ԒTl^�x��L�>��oT��~��2����;�r6�H��灥�{/��Uߒ�����T<Q�KLZ�I�XR�,�
����_��\�Q�i[��>�P��/��Z>���:G�Xl�@n�$U,oPB�7�Qv��ެK�a	�(������^����ԑ��;���փFm���1�?	�$c�CY�G������� �xH�����yO[����N��_Yȇo��<��<ۊH�C�T��.C,i�� �����O4yْ��w�R��.W��c�>u�n�R��ټ>�i8Yڎ:լ�}�ؠԴ-�D����5�DE<�����@'�r���pv߀��!	���@������8A�4�Hm�0��h�r�$xg��$�-9�%؞Sع�ճ���'� f����s�
�M�����)��]����*������|�*:�x�O�W�3Y��F�V�硿>��1��y��W�7�Q���}v>\S�ϯ`8tA�5�زf4�ы�׾��J �q6�r����Ayt)26�+���i�N[�v{!�(0�6N�X&�:���M�%�Yh���q��nr���\\{��Eq���_�ŗGO�\m��7����rNWPk<�������G�m��o�.⺓�.쒋|j$��Y����һ�y�����o��(o7�͡l�Vp:�I�"7s/e�Q��(g	�c���/��Z�Nu��V2�����I�д�4���]�Q��q[t��g�_XI�a��Y[�P�>yEN��v���SQ��(T@s�Q�H�YڲFУu��=����Y�Ո����$��*�ez����ݖ�ՉG5=�.��b��D�d-6qw���VA���(V�i���5�J^�O.���~Dۿ���%�
��,�B�Sj�Ի���:���D8i�l��L����t`�~ߍ�1�Cݧ�fƀf4���yғ���U�uі�N���+��{�<�\�π�I��?������j��ڦ����'���iD��kE���,7k�%��Cl��זg�<��I��Zښ5}�mo��E��*�o��E]-�����_����/6\�fQ�z�?m�?!�9������[̻���;[S`%�Z�����UZf��_�0�M��!l��|�=�f7�{����$��DԭV�=�-A�H���X�P�A��]�w��P���%c�#^�8�rҜ	�9��Y�6��~�-"� Q�=~���yG�����"M��[�����XЕ�Ar�J���ݩ*%�eW`~|��5�X��ٓ��c�����T��|������ D���і���
�O��ZQ�ek�v)E�^��/�,>���� t<�$5}#H4m�ɼ����|����$@�v:��q}�g�F�p���Iy���X� ~  �u(m��J��nI�}���`d�����v��}!ܢN�1mu��|ԙ�V�&�𡢝��	���0�Ƭn�Bٰ8IS���{�ot�����!�s:"�ȿ|�����2 8Hd���8�n�d�{ڨ]F|K��m�n���F���"�{1�x�S���-Q�=+NK|0�䠚"�!��I���C�7�1�'"�*��X��-O��e������R�1��.��m�/H��;�ͣ�ͧ�%��xo�t���lA&^��Z|�X���٘�o\��/��V��f�قj�"P���w����س6!���?�	��P�V� �%}��Fz�Z믗R���F:�Y)��d�՘
�"���I>�������&��O�䐄��W[rTf�g+BK���<f�>��_f�(�Ϗ��5���G=���E4�����N��D���Rɩ��:�� d��5̛1�$���CT���G���������(6p���0O�l��;�\%��R�H��� 4������/~ǒ$K��K���8���A�=����|!����-u����a7�^.(ad�N�w>� ��:�}�����C�W/u=~���"����a���q�fT�ϩ����}`�0��� ��z��&�1�[�k�s{��BR��-���p�H�ƋSA��"hYyL9{_xz�����?2c�8fco!<M�<F�[���<B� }9~�V-'gX��Ř��T�գJ�����ڱ�u�����m������K��7F��y/��OB���#)��<���>�ߣ��W��R���Wߗ��y�c��{9gp��%���o�>�6��Vv}&�������[��QK\���[ϕ��O�T�����YHOa4T��W�G����!��'�������ߏ���B���rw����^�Nz����⡓/N1=j�eg�j��|�T��7���U��N_��pr�@��`��∭>�����
qXx#�i����M6��mg;��n���N;nq}���B9���s6 �<r��ǽ�3j���f����r�1�3tǤ�1�u)J�u{A�;B���aG��|��K(�/Q���[��dw*,h�+Bz�Wb{`I�@@8	��}�-F������������      �      x��};s�H�����N�)#x����k�5ջc���`&�� v���
'���i-��������i�?��="�$�w�k�� 2����΢��_�����(������f;�p�+�L�����u�6~�_�n�$�a|���<� �����j�jGP_�z*7.�Os{��0�Dg����kH<����GG^���q:�q�v�#2����� 	>��SӺq�I��_�CO_���;��Wˑ
����e\ϛ��4�>���.{E�]���:�1'�m�n�6��<p\̗ms8����Po��f:�'����?�C��4xV�.q.TY����x��c3��2��5�+�<S�꡾$IAs�ڈ�$&Zm�B�#X�j�;�	�5����ЏW�߆f\)���n�ZL-pW�-�kE�Y�\��qn�Nj�C�gB_/�z���M�a���v9\���z[m	����M�l	�w�e�� 8�sA*��zl�-2	·�Ŏ����;�^�c�VC��`�<��7m�>�/���G�l*�)�O����
��幜�~/۪��c���-����L��V?�X"O4*76���F���L�Q
��,�,�ᦿin���}��ʃ�j�.�BZX����e���0z=X��,��Py�,
.�q�U�t��󼐊Hd�Gc�n�~ޜ��6�z���P�Q�ڃ����� �Ȳ������O����+�ܓ;H���2�u�3��ς��ԏxt����yV�Y�H��~�P�W0�H]*ܟ'�d�"+y����̚�u#�U[o��?,R�	�煗X�J&�R�-��i��oyO��(�,f"-E�7e��	b��L��H�"Ȅ�4��΂Lv��<+[U�Ad��E�3Y����2���Y �˜J|�_�?�����\>](�3�?A.3(j�\�P���9�Y�&�Y�y ���4�" �L�,� �$b<ř�
}hhu.�6|F��"T�����TM@WU-�UP3İ��U��Wp�L�mQ4�Cw���+����&��΂"�A��"��尽gS@���:�P�����	�zĠ~;�f��%�0��A~�����P}�$Z �Rs��*|5�f��n�@���!U�����lX8�kSO]up�f+�3~�r0﮹&���� �6�N�$�ԁ�;7���T�FP7{�#L
�o�����~fh�}��0�'db��Nh���>���~�2�u� LM�_��z._�dr�*Χ�Ď�༭��m�.,��v0|���͛7AA-�-��?�W�hE��b�g1��ײ������)��o��H8����<r�u�qfX����������[J����u�UY�®v��(>����*%�6�9(��m{��Wu?����j�7�n껠��=��?��=^ڷ��3&��ǚ����
�i�=&	���.<�V����?��RDz�Ox��I��g�M�*��윅�����G_�RX!_�X^K�ƃbG� P��M��b�	��]���	��
�4NO��d� ?H��	�W���@�s�D�`��L�R�	�\��
M���?66׃� ڵJ�6��ט#�q�%��Q<��][�HPFoi[W7�<D�݄��t�Z_����:H	A��*E^`9��Z���T�~_�=��q�H+?RD��K?laá�H:账��\9 L/��	�@u�����:�~|U���_5H�2�Ra7[(��y
�iMVpaZ1���+�ˀ�C,-�)C5� O�N��8�S	x�Q��+!&��8��e��Â�|�,%7�L�	X$?�o)�O�f�9V�����?�2����)�����8tS�dJ�GyL&�����OʄJN(%���\���C��`c�]B�������+�L�/4�x�̓�8�h��<.!�"5����W8���7uՑ�y�@|����/nc�S� �b���2 V�D�S���F��7��
�a"�L�����aw0~ ���lE�0�<�o��oL�H�*�B��F�:����"{��@�Gs�Oq�~;��T#�7G���k{��C��?�
��׊�f�����,��ǫ�BH/ڀ��� �RSo���p���K���r�j�J�vC>���˶*��]>���Я���`�Ћ���N�T�^I9x��/�f���`l�d\�`"u���-�%��֯��E�c��cakX�/�wx��e0��D)7�A��y�#L�y�M�_�L[�=�_#KU���7�g�IǂF��)��y�e�4�r*F���s�`��ȅ�ZI���������|���F�ė���%���OذC�!V� �[�#��w��c���s�}E������q�����T�c�#����"x:T�KP2ƆW���0­��}�����[�8�Pl�~�-䱀�Uh������K���)�Q�� ����3�Ϻ�J�Ao���y��Ug"L��.�͝��Ѩe0�9�]>fD�i40��C�����0��Hru�F�H2i&�T�ȰY��$f`��f��b�hs%�d`���H�FF��YYЅ�$�ch Z(I�@|U�#�bZ9��_�=��%�ah�2y��0�8s� @N�3����D�	l�C�<�(=�!<u�	��8g�����������7C0�B �q��\�|;�$LC8t�v�C�EP��9pY�.a��U|�G���8x�5���C��F$����l����5^�o���	<_tT�
�����Q��H`aP"�ED3tY#Lr	��צo��w!�	��>�!�{K�VO�������������K����&�,ǂ�Ӿ��;�~�6{?,W+CVJ`$�/�=��9O�p���ն������E",��tM�@��֣BHD26gꍚ��~7�>�A�t4�cxQ��	���M�������;p��d��L�6� _��N�<J,��GO�8����qt��Kf)���eʅ��b J���|sJR�n��D�I^*��9�{K���@ɜo�j��ʃ�x��f�)����,�����WC���εs_�$�@�x�ʅ롄Vhal����6��4_�*� ��~��=���	���P]�~��h�9"Y�7G������0AX���\�y����$��0�l÷Ћ>%��u���Q���|��TC~��V+�r-h�*Lhc�4�"��<;�Oe�B����2�.��� 9ԍQH�}.�A�E˝� 9�$_��0;�)�X{��8ƌ��F�)�tI7&0�0u�HL_�%���� �@�Z`="I�%����H�b	C�"I&+a���m$)��ֵ�/�$Ô���boe�T ��LB�Z����0V��T�$	+M��1ƕb�%�0���̆qe�2����JL͹��&Kܞ²ZQb��n*��XB���G�PS}���k�`��'W�C��_UÆ���e�	���P~,��� �0�L`��m=	���)��?�ͷ~�=tau;S���M��"��Gl�T�Gc���������V�V��<��[I�I�)�9�G���w�1�Mp<�nf�\"oIv��oeŔL�u����$�����A8�[O���3�LE]��V���&w�5<��%���4�,���Jc��77����ȋyv����
2�g3y�i�A��Y���zXqN��j��/~��q��<�٬U�z���rH��N}�y�<�	��z����уK�Āp3|_�Q����_���ke�w
��b@p8���C��~���Gc=	/6�4�/��nWU��X�[ô��Ht؍ۖo-� fWM{,ޞ��f�����g<	?���L2C�c�fh���C�ĒYJy�[퇺�����A��A�Mv�9��8Q������k���َᗊ��H�|��x�A(l=�������#��߂�`�_����g:���<�-~����{��	x��篟��C�]rdi�������B��(�3��K��=��sE���Z
5)?    +���P����=�(��l���{�<�ܛ��O��S�Y��:�~k�s>����0���CfW�������2�%���{Gm�$p�����+6�D��A�߮0�����F x?O�a��{�Bd���A48_��{ci����<�aA�((�Q 0��~�����j�'&�R"8��ؐdVs�ȓ��'���Ǿo�<M�WSǈ���"L@��J�4�[�z���o����"�bI���80��My�Ē�L��Q�p��}��sL�ls�<��%���H8�5�)Ǔ�UK5��7$��J�:�%y�2�.ψ�����b�$��83I��l���̅�vKZ&�+�IIz%�D3O�%9�2��3�G&_/���L�`%�������
Cc�g�\�xº�ঃKz���
���x�>��۹����N�`��<x�_RG��|�g�&8����۪�83A,9�L��2 ��b?�e5�� f��ߠ�w�F��bԐ1C�zh��_=���-��nSwwp�KH� �i��<т�KqT^z��/�փ� ������YHX�C/�V�Ie�����9 �o;Ē��b-D�%Փ��T$��o�A!<h�z��[���xކc9����Y,)��H� ��'���.o��h��gX�v˧�������?�����ז^��Fe��b�?@�6̳f����Y{���}A�?��%)��8����k&?�0!��[�0�XJ����8Í�OY:ȃs�X�c�KM�G8�XH�b���M���W�#�顣×����%��a�>�7������T���65K�en�:��pǁ�S��O�Y
�2��yS�z9�)��"��v������o2�s=��%񗥌��vR���Ţu�I���ʮ�,e<YM�����A"R-���o��ôaː��p�X����"I:f0f�����C�C����
���r�@����0N�|;���Tr���ؽ��<A�v{����/�!Y,eHY^����u�v,�#L�&�#��Le@r�ON�X2�Y!�B�ֽ|��K�/��jH./��bY���2/R�2�v�RJ*,	��2�2�$����G�y9#�b$yB�/F+!�|N�'���e%�"�%ő�t�E&�R>�I�X�8��@.���p�XDK�Q�⥡�n�:���[��f�n����z_�>��Ƣ��a�My�R���e>�� �v�j�*�݅ρ:&���˶��/%%Hy���Ӻ�$��P&������뺥?,ى��Os]w��XajsG�,%F98�U3�|��ȶ��*.��GV��Y��b���r�O������&�G9[}kGɷ �߶��.~n�&�I���
|���U��G�U{'���T���T:vl\�A,��<���]l%Iy��=�M�Z�(�F9���v�e�����ݝGpd�nPH�JK�R`�K��.y��@Q�e��d�ׂ!���>���10u�U�~mx1Imc,�G9��?�{a\�I-�������PJ�(����(�F9��2�$��_W~�0�c%o!�$�D9Lޏ�f�`�_3���HQ0��?��?���/� |c�Ps���@�]��rƄ��p~�v��ؚM�_u��)��{� �{]5�MK]ڍ������$�rؼ�~n=���<�#CL�KR�����˘�&�]U���p.u�%�O������i�J�ƒ���ҥG-Qv��Q7��Ws3Ul��(ϖӒXrwyf܎)A�Xǒ3���V�E�]�r�KIP��l��2��b�ja�ArM��ny���Uዶ`�X*����j����ɂ�G9^2�9K~�� ��<O��KV,y��@�PI� �q.������nH#&��1��3R��/+qUB�#�E9lŏ�#!!����0`C�e����s���qXI��P�4�¶P�Y`$]�KlX�hW�	�����ˡ�`x%��C�.���Y��"Y_|Q2E9cB��H�&�h�!ɮ�	#i������E�$q`$�3GL�1�!�y�j#���!!�ٌ�����F�H]�iv�荔���k��Z_I�ё$�3�s�t)�7R?T`E\��h��]4��p}=͖������bq�ofp�h��c$v/x�j�,���n3��ˍ��j\U��:�"Z��$[�t(�.���I	X�Os�:d#�D��|7�!��T0Xx�Jt*Z�r�<8:)�7u;��6�c��8��7RgT�ǽ��CݹOօ�Ȇ!�T`�����M�]��Բ�|0>���Y��.a0�=^ղ�
�'����w�
X�g����]s�(�a蚩�d)��Y��;���[H͚w�=M��R���($�n=�]E) *�hu��%����4I�,<�Z�������!�+,������-*`C�����$�3�A�`�phv������c�Rя?�<�s$�@m�y��@p�u�-<c�K�e������Q�\��72�@�k�\����U�A,�}�6�cm����
XXoaeNz& HLxٳ���!�}��ق���)0��*X�[��P��~��s�EX�ӝ��C��7> bC�u'cb4*?L����:~��d����V�Ml�:�:��#�~���HڭȊ�}Q�r���鹴���t����H֮��%��Jc�����s�yuPU,ɽV��Ε'�d,f!9�Of93R�T��>�7�_5����r�l��`/ּY=('���Fҁ�+�5�J,������lBS�a��KDoo#��ƓW,�qZW�5?���?4?�tX�n$�X���������}�4^P�$1X��^�L�U�s%O�/��:#{_�f����H
�(�K��n������a�[�ɐ_��A���_���w_	�Q��3;C���.M��qD��f8��L@�.d��,0�y�"J|��w�h?
j��b����	(��y�zo#��R�l!��n_mGu>Ӄ�d�I�����A%g,��;�I,���O�����s��O� @�~%�}��s��b��y���ZCɲ��r�i�I�-��+K���=�R9�cN'�:���6n�n쥨����X����K%&�E��K�^����qd%���B%S�2�:�q�����������:����7�,жQ�hɪ�z;�.�b�1�`�������R�8���g� �A8��(�b��o���`����?�?���#Y���������ჰ� 21{�|M�n<0�-a�W���O�i_�a$��3
��4��,Y��d�B��!1X���f'�>�]��l.��z_�b{z�_�,�Ul�V��t�M�v��SF2�%���{���W��V��^?P�XP�gyF�%�t�I���c�z�_�q#���*���SYo��ɢ2�����fq$[&,����zOY�A�����v��w�#�v �K"����yDy���p�{��V�I��t�%&�A$��~##���^ÑtI��l�=�6� ��^%�fv�H���,8쎑lm���b�.��HqjI�����a^6�y�����S�f���y#��$�ˌmaI�"g��|ɍ�8Ĉ�݈z������K�B#u��@@�*뺽����Z���ڝ�FR�ZJ�5䅙ˊm�Fr�<@X��]��9�D����_�C%��ȋU���w����oKX<V=�p����Ve��j��e�E�
6�o!|#)Kg}�RW�h�`�,\���L;��Uw�7�+�RA!�N6,����F�T�j��/{�]�gX�kg�,ίY���IR�,����/Ça����B�
OM�RP���+UB�L���@Y�	�ft>S.�<��h%G�w��}��\S���j6A��d���gg,>��;��$�vsu��x����zS�����7���{}��o�l�T�-73�԰��F�Ѷ:F�T#?q"��ڶ}���a�F���rK��F[���F<�rMF����<h���k)�6&���01R�
l�`��%�)=j�9q��GqHע�Q�$`��.̯)o6>��j.�͉�}�gpK�k��^�ܣh    +Y�e�"�����\��Ѷ��ص�x�]j+�����K�����a������6K����^\�*�q��]_7���W��� oM�*_�<Q���̍}˛��0@
�SNW*@rk��������(rn�IWuTⅽ�eH����Sâ(�0�4b
oX����N��g�P�Փ�9=x���b�C��N�2��Y����Q��&��t����|]"�僜n���Ra���A��g绦���祡y�s��o-)����3ʎ�~��)Ty����=����{p,�K\�����mL�oi��p6|��)T��q���{c�a�7n��0��;܇��5OQS�,e�i����G�r<2y�*�0��G/T�`#=�ZH���f}H�w�j%���-��a~���*q�Q[��xp�Z2K�)T�����*�Px��f�Ղ[x��aY3�L�}�Oq�a�`J���ք�D�0V-]v��T��|�)w�*{E�gG&�
-��q	p��J��~�������
����yu�lS�;����?۩9T�3���R�{	�y7�'lt�*��af�0��K��P��D"�v�R%�<��,�&S�hb��Qs[,~�����7��Ÿ�*����`EO���-}�crT2���N�Re��ңJ�T����N����a�>�b�{��!"DrN�Yb��'��A�Z�ʩd�{��]�����aĞ�U��>�����X4��-��Q�#��/kaAуw��9�x����䒣7����ic�^}9s5r��Y_]= s�"w��߶b�C���sH$9���(�:��5T��
J^���*��E2���������B!���x[��J�L2b����&��l����c����o�͂(���x���ѷ�u~PQ�H�E��Uq����"�DNF#�[�}��I苑=9�J����&�R!�(�VU'r��Rs9��U������.�J�{A�-�4UD���VGw֦�ϱyL�%r��>ئY_ε4��g���~�M+�uy�x��I�#~�(P!N��{�E��Z���r*w�6�Ӧ{��^����������^�W�1K��ǔ�������t��=&�i������F>�P>��}*yl���Ǟ���O&S�'󇓱��C$g*�<�;�H�0>bI�����'"��ŞN���q(�T��jiO3>5;z;��˫x?֯��J�5�K������H��
׽I�*������$R!��|��5����Ͱ`ը�Wߌ,\��q�vU���$Rq��SH��n�lv��'V�cO§p��y��E��IQ�6���]�ÿC{	T�3�9�����8�Ru=���ܪ���[dq_�D*Ҽ�o-��� 8����} >�'��/�����M �	T���4�K��j�!�Te��ی�c�^/��:훶��=ձ`��K3��0�+�
N��3��t���R��ţ�]��ka���A:x����최5�����;~YM�`8Q8�o�y���_�{=8I�B��@
X賓F�ģ�A�S���z�n����.�{u%��F*���a��A3X��_?�7����������UzU��D���r r�.��C��U�s�-cU���0O>�C���1<������j$�
s��
���X���p���z]ULF�%y�y��u���v�$V�-}��C�%��0�3I��.�k�Hb�RoS��*�U�=�Z{�'̃���Z�����Xn�I1|"=���{$��+��04����r�K"E<����;�'.	�H�P�R1�z����2��ދy�$�D�4�����dZ����m3<�9�:�][M���\�Q�q�o���5w~��5/���DJ�"��ɧ�=�r�Q�+vS��A�j�,(�߱��zi/u�bz�nT.,����g�*M����b�p.��;�ѻtc�+�?��_����&��	��܅����m}>�8�u��aA"EAk�r��eP�ύ�*D1�O�V�y`���j�H���ɂ�Gx�ۮ
����<-`��4���}5�v�d��%�z��53�I}O�R��j;`�e<�XˠQ0K�S"uA�B�=��$K���Ϩ$��49�^M��hT��L*~·3����H�����nm���{���z��'�Cݰ�'1*i��khK�J��ӥ����=mc�Y��ը���W(1*iz�Y(1*H齮#�O��<�8iFI��ĺ|н�P��R������W�
=h�I�
(��K�\����<ӱL�2�1��nN`�cMi�����ac>oHW����^�g������<�¼��i��z�-}�W͜��<?ZF'z<��~�әuÇ�>h�H��w#M��������8<&�Y=��<J=�G�R��������<9p]ī���w�&z�<�����6lx��iɑk��WWQ��}��P?��"!O�B�Q*�WP^.����tQ�D��g�׺fr5f�y�`A����e���-/����N�`����{�
z_<3�/ۺ�~��-$q� �iŻ�'({ռ��v]$�By�/��Y>D7����W+<o�y�x.6��ʗ�:+�l�_7��;�ϖSh��at�1�s������o�b�F&���ßQoV�+`�F�^�*��:��Ho:-���F��]���G�����x��˳����Nz�{�<�b{��ۖ���di:��e��~�5<�b���A�8��;dbF���	6���m'0�=���!�?�Z�y��i��mjԚ^,�#��J�����t ���r��Hӛ�^YO���@�|���{:�V�m����v�H����ވ�����>���ˢHED�fz�w�
��N}�&sަ&I�
����OO��Ҟ��E��	?c��l���J��D�;v��{`���Q&x~h��AHě�Ĩ�t�g���넉
Ť�qz_w���Bg�/�`�Ԍ%O�,��u���\<h_L�v|��K������>O[3S۾��t���*�{�i�-]�^�O-�����c��c1�H��T9��A��7�Á	���ߒ�/��?%�c�Qj>=��lww
���X���� X�D��L�-��~�7�S
O��=)��{�L�=��˟<L}<�&6�T��qT"�xP��<�n�,��%�� ������&[��=(Z.�󰘥�V>؍��]ȫ{�z�d*g��#�3��m�*���r+b_T	Ѩ�ڽ'�5�a�����/S��;B��7��an-,	[[y��%&ӿ����|䗩h��j�,���A��_$H����n�6:-�:8G~��
\���B��T��ҳ�Jܠwd��0���~
�9�Rk�x�����I��iO�iGA�?���>WS5Aa�V� ݣz��'f��#3��x#K��`�d����\��h/#��/T+�2�;\�=��Z��_����ȭ�<.-��Ue�J���j��+��� �b&^[�cuu%�Gˠxy<�M�P��Vʹ���ƽ&fc�l��v-n��f���>�O�x�٧�o%o;s� ��d-\�f� �+@r�����I��V�ޒ#e�%ፖ!�"3��L�*�uv_��%���2<&ekjH-D�e_�f��$Z����>�X
)��1M��4���^�, ���5^�[)GA��ؚs�"�OXc��-2�5J����Ho#��7����Q��@�k���/�:2�rZ����ο�ː�ם�0dS7`��zW��1�z��k���&��V�tI,�lx�G����}��מ4e��e�g�Y������I�l�wN��z�Y�&^��z`ɫ��e�R=��eSV}z�%�AũIR=�L�]ʚ����=��Ex<,����p�͡:�~�z�k���k�fR=��]Jk�^L��pz���{d�f4��w|@ ��)\ƹ����X`�`�CKב���(�z-����~�o��6l�����Ӓ@�����$o�o��_r`c_	��vۢ{�y�'���j1�B�+��ٸ(�j�H���8��Ϩ�@\>��z˽����zV���^�-��៛���~���}�oUM��"��u������q������S� �  |m�<�D�I�;ՓCވu������c�^b���tT�A��&����,�����V�+yԠ|��J�G)�*��ݲ����E� %�ά��q��Xn�㵏C��i����V��I�8�wp}����⵮���@�0S=>�\�j!��fz:s����:�q�8�v�D�ڌ�=�J��1�H]���ͬL�ďwt}���?CvVx��)J�=�^W����貎]�G���s���e���R���Ӥ�G�g�B_���	*�҅W��+�7'�z�������y�)
Ou�����=�m�ii=2�l��-.~�O����|}���^����<?I����~}B��V��a�_�7"������XG�\��h�+����֕��8H�"�w~eAR�?@�7j%Z��۾�t�%N����r�u����p��1rK^�h /��T�|O���H'�p��A�˃:�:�� ����|�DG:�D/HK�J�=��_���׎      �   [   x��;
�@ �:9��KQX��M�()�H6�ߵ{L	�p<���E��e�X/�3��ќ��U���5�f~��=lo��p�@�M��y�D� 
��      �   !   x�3��/H����2�t,(ʯ��Msc���� ���     