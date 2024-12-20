PGDMP      !            
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
    public               postgres    false    221   +       �          0    16915 
   respuestas 
   TABLE DATA           ^   COPY public.respuestas (id_respuesta, respuesta, id_pregunta, respuesta_correcta) FROM stdin;
    public               postgres    false    223   �O       �          0    16921    tema 
   TABLE DATA           4   COPY public.tema (id_tema, nombre_tema) FROM stdin;
    public               postgres    false    225   ��       �          0    16927    tipo_pregunta 
   TABLE DATA           ?   COPY public.tipo_pregunta (id_tipo, tipo_pregunta) FROM stdin;
    public               postgres    false    227   �       �           0    0    admin_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.admin_id_seq', 1, true);
          public               postgres    false    218            �           0    0    participantes_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.participantes_id_seq', 21, true);
          public               postgres    false    220            �           0    0    preguntas_id_pregunta_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.preguntas_id_pregunta_seq', 520, true);
          public               postgres    false    222            �           0    0    respuestas_id_respuesta_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.respuestas_id_respuesta_seq', 1805, true);
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
       public               postgres    false    4677    221    227            �      x�3�LL��̃�\1z\\\ 8Z      �     x�UP�N�0����~���cD��F�ZF�Kb��k#�a��0v�ԍ�?ƵEEY,����$4#Y\��W�D-�p"\��GB
�#o܀K��0T­%ܸ��ocbU�����6|�>aX��;�2ҽ'h
}j�q�J�E�=a<��&�6�.�y� ��z�Ƈk})�qC8b�<5�2�{���˅,��|7��gb!d	[���8��BV��d�Ŵr���R�5�ړ��й�l�;�+��+˚s�i�v�u�s�u�J�2��-���x2�������      �      x��]͎Ir>�<E�Ok�7��f�d�Z���Z#K��6�K��M�T��dUQ�>��~�0G���m.�7����̬�R3X`GRgDfFD�T�&_����Ss���U�9]�S[[e;�TV٥�{�7����j���"���Ե�t��"�~��\�\�6SE��` �ݚ~��ۥfU���tI�y���f�f�p k��t�J�jlؔ*[��Х�/�K`E�s])g�\�Pٽ�mu�Tֺ2��������f�ΊBmf�,�y�\m�F6_7*S�^�l �<�5�v8�F�:��Ѵ��^��:�6�O�ܖ���:F���	s�t���%K/��{�yT��F� #f
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
qXx#�i����M6��mg;��n���N;nq}���B9���s6 �<r��ǽ�3j���f����r�1�3tǤ�1�u)J�u{A�;B���aG��|��K(�/Q���[��dw*,h�+Bz�Wb{`I�@@8	��}�-F������������      �      x��}�r�H����
H+�<E��ݼU5�s�V3�LT!6�&��W��j-����0���j�c{�{D I�wg�j�@ ����E����]$Q0�%:����v8��`W���c3݃%��m|3���<I,�,�P�y A,�̓�0Վ��4�0T�]s{��0�Dg�����5$
��Cuw��#����8�8T�����oI�����i];� �߯�'��Ȃ������t�)�!S����ys��fۇ�:�T�e�H<+>;�'�s�ݶ��j���3�����m�P\���n�Sx�������ץ����p�s�ʂ��?ƫ~���Y�6{�k�ft�S�꡾$IAs�Z��$&Z-�B�#��j�;�	�5����ЏW�߆f\)���n�Q������"�,f.\�8�\�?5��3�/��s=�U��0��_c��^�M�����	�Y�c6�ܻZ�TD � �k=����Î�b�i����±o�!HE�h�͛�V{��>��6��a���|���B��0=�sۏ�e[u�~R�|ڂ�o��0����i�yژ��P��YD4"�2�[)$f�4���������W�_���i8M"ia@*���������`	���oC��(�܌S}�¦;̝�TD"�=t���`���x̶������N�GAPjN��O�T$"˂����rd?���;ΘpM� �PBˌ׍��Td"?^�S?���	���$�Z�B�����`f��T�?O�LEV��ˡ@�5u�Z`���LCX�&��/��LD�8[Xo�t��&�RQ Y�DZ�8�7e��	b��L��H�"Ȅ�4��΂LV�����*� 2���LRQPy�|vy@��2�/���g�3�'��ե��=��	rA�PS�2�R� ���̂4����h�\�Qhde�79�cg�'����\Vm��l�E$�8xY]թ����Z&֫�f�aG��ï����ۢhN���k�G��7�'��΂"�F|H��r��3�)��|JO���|��ㄗp>bP��a�C�
j�Տ� _��8�2T�(�@���
_ʹ�ᇹ�6P�E"xHU��1<_��I���SW\�l�zƗT��5���"���Ц�I��:0v��0��0�fu��= � �&(��1���g`�����31�a �fXw 8���Wc�l8�O��vȔ�}��05]�����%���E�<8�jj�.���ƧA���n������7o��Z Z����G�hE��b���|�,�00�0<%h�1�[36N�4�4��dmffu���6��n��t;�R� f�}�w�@V���ݦ!�=�0�U��h��>�T�m�@Q��]�X����M}�"C0������C�V�c�/{�����`���c��m����mu,�3�-ED���gK.�d��4�W�/e�,���͈5��"h0�
������Z�7;"�ʯo�v;�W���`�R�(MN���6(�N�윞����A>H��	��{ҫ�in���@"l�A�
&�O)��r�Z���PX���?6׃� ڵJ�6��ט-�q�k%��V<��][�HPFoi[W7�<D�݄��t�Z_����[�� �V�"/��wS�m`s*�[߂��VX�8Z���с���[�p(s�:���7W ��ay0P�����N�U���W����TX����`j��{Z��؄VL���B�2`cSe�P�-���46�+�2Jct%ĄQ�y ���Y����#�䢞�d@~a#����26c��1����������渄�gHƦR$C�:J7>_)*9��X>�r�/6�σ�w�	mr��z�^�� 2��W�8��7J���!�� ��T���̂�\Q��'#T��UGFtDp硿^ e����A�5N<�ń���"��§t�=0�5��o�=��D6��3*$na����`|A��lE�N���d� IQ�XS�h\W�zL��{4�ڋ�g���>tS-�D�9 �B(���WaH8���+І_+��G��C���W��^�uA�-@�����am��7���n9)�f�:b���3tQx���J/˪ ��v}��j�C�2�f�D���kh�~8�S�{%���¿4�����AۜI���Dj��)�[rK(���w����;��ְ�_���:���`T�5�R<nh� n��0'
F��󼛎����
�sr?G���3�A+n2��0����Sx���ji�+-�T
�p3���x#2�0u�K��!��Ӆ�a�^���4�/�wUK
��;��`��C"��d�T3F����K�x.lߧ!��Qu{]/�t	#\���|F�YA�E�t�`�<�d��vG�a�[a��Pok��Zqx���!��[�c=��.@7���2aSF��AF+��g��tѕ,�>�`~w�[��D���K]"��;��&�Q�`@sH�&|� 4�$�h`
	��!Li�#`�q���� ��d�L �d�a��\I>������b�hs%�d`���H�FF��YYЅ�$�ch Z(I�@�U�#�bZ9�_�=��%�ah�2y��0�8r� @�#����D�	l�C�<�(=�!<u�	��8g�����������7C0�B �q��\�|:�$LC8t�v�C�EP��1pZ�.a��U|��M�xH<�b`y���af#�\C��y6_z����ʂ7�끉���/:*KR�������_$���0(�"����&��f�kӷ��;�����v�����A�������fS�ߌ�o�H�%	�aW� H�c��i��ԝ�A?T��o���!+%0����@񿜧y8����j[��]�L��ӂH�&a�نO�Q!$��3�FM�`��_� Z:�1�\�	��?Av~�캾�49���=�%?h�>�ﶓ�8�ӿ���S1�0����x�,%<?M��bVdAI�oN@)Bʡ�Օh6�K%P0��j�rs(���\u[y�z�,4�b�ra�����V��j���¹bd��/Z�p=��J -,�m�����f����XE����	�3P\�O@�N���R�D����b�8����W�m�	�2����������%9���d��^��)�>��=F!���+[P!���\�˵�I�0���Ҙ�`�#T�l3>�a5�%�i�.��� 9ԅQH�c.�A�E˝� 9�$_��0;�)�X{��8ƌ��F�)�tI7&0�0u�HL_�%���� �@�Z`>"I�%����H�b	C�"I&+a���m$)��ֵ��D�aJ`]S��҈�+In&�U-���`�JH*y����S�	�J1���H��eBFø2Kx�h`V%��XR�A�����V�������9� �P<�m�+�T����^��5�_�W����ˡA�Wհa:��gYsG��?ԃoc��8@�L+���C[O�ksJm�os�jO]X��?)�_��H#�)���o�z$���l{��üU0^{�VRx��z�?G���}wQ��'�s��f��%��a��VfL�D^�z�I��)�����4�NY0CN@�T�U�ie
+ar�]�m�XriL#��t		�4��ys�ቌ��g'.^wW�Y^���L��͊(e��Ês🫦������ǟK��f����({�&�+u1��8y8Ɨ�0�/?̣�`��f���Q����_���ke�w
��b@p8���C��~���.�����7�4�/��nWU��X�[ô��HtX�ۖO-� fWM{Lޞ��f�����{�	/z�p$�!�1�
3��S�Ob�,��׭�C���f
i� ]ɠ�;����b`����5܀C�l��KŁZd��v>�V�� ��[��:|:�l���0X����=��OBg������q�<.��P�� ���x�zQ�-b���#K�\D���tס��.������J�j)Ԥ|f�y���	��ck    nQ��|���x��76���~��S�Y��:<~k�s<����0���CfW��������fߒ~U���6T��g)��M#�:x�+�� �s���`�A�C�'9�ل���P������XB�f��� aX�!

�U ��gj��z�]`x4��a)���l�2�1�|�����$�;����+O����6"m��Hк��.M���i�[G��3��rP�~@,)մ�Q�)�|�X�)݂2#J� Q���s���e`Ι���d�R�	2G4��)Y�TCn�C�_�d��X�W)��8	��+�LR
_�#�TP*���d,���X�2)\J�+�$��3,ɑ�q6�p�8|��+�3�>���Cv&G,�+4�}�mrZ�	�΂�.��J*�2؎w����_n���o�K8y����]Iu���@M4p,�'`��U�pf�Xr �����b߈e6m� f��ߠ�w�FޜbԐ1C�zh��_=���.��nSwwp�KH����j{�h�Î�8*�?=�֌�}�AP �M�gb�,$�즗 +�X��2�c��f���m�X=Y����z2�b�J�d9�M�(�m�\���a�_���p�/�:�7�;�%e�� v��1����o�!`~ ���n�[8,��:��Z��m�IiT�@�*��m���k������?������.IYeƱ�T?e�^3�A�	��ꚑO}�R�Ĝ���m|��A�3ǒ˰^�h
?©�DJS���n���P�=M����@]-	��������Ͽ�����P��h,eLL���j;Z��U��γ:e��yS�zn9���K�c�iq��������\��bI�e)#"���<e�~��Emf�����+5KwVS�0"ⶑ�TK*1�q�����0mh��$)#!�f�f�%�H���Y!��qhCu�m�{ZA��YέH~x>�	�o'vH%��<|�՛��cl��!�H�����R��先�m�\Ƿ`�"�� h�0?�
�ĀQ$w�q�4�%��*$��a��'��X�~fCry�˒$��x�J�	���RRaH����'�0e0\�?����#��Hy���t�~8��D�6�1��� �G�e�wHُ��1	�p,���3�cHFB�s�i��o�Q	�r��K�i�,+1B�	L��?9&��\��,�QH�"�
o�>��?F��S�N�����6g�V`ġ��FĜ}��q2 ��M`�q�i�Y{`���%Qn�S*h������iv�l����57'��8�Ӛ��ĉ�$	��n�k�K�����3�*��F��yv�^��4[
BJ[Emd��[��ԁ�uA�O�`2��:2\�6C-j�+X��j����R2� �RU�@y ��Tm`ā+0�s˪1#����|7�{v��d�1�a�&����H2Dl3��4�c��8��4�+\��^"ƨ;W��ɺ��Yލ�;0��[��iS}W�����y./̃��m��t��s�U-+���X�C5W��?�7�v`���Ep�����%�5�������t�Y󎰧IV�S
Q���d�>ֵ��Y3lte���D�f�|�#���M#.t�mb��n���%<;��]���"��Nps��p.�=$�u��C�#Dx�Ɨ�7m����~�if�ՑH��\3��@ep���\��/��βi�#F������72�@Ѝ;Ȯ`��b��� ¾i�뱶��F�����۹�p�3\ 1�eϽ'���-�� �mqz`$�(XWU��P��}�㈱�$,c.n�||��DL`�>b��M�a����L�S����F6��lU��B��s�<��G
ҍIEV<�bw������r�`Ն6������f��Jc��`a�r^TK(V��6��$��E�,$�V�,IL#��,㳶���UT�������7���g��7����H�W�y(�R��ل�t�4x3V�p$�F�Ɠ��ܢuZ�IBk~,gh~��PJA������,]�.�+�L��$a\c�yf�T	�J�E\BUuF*V*w�f1�~�H�V��%,o�@��m�z��@���7�~��H|V�"_���"0��af��0:QWݵ#�6]�Wf�p!�u�f�qS��g�S������0��uؘ|O@�}z���o#a^)	v�o���qT��0y2~R35�0zP�Ka�jG����iӶa~jv�i�a�ϡ����`wβYl<�7�Uk(�	:\}5�=��%�|d)�(���T����dR���m#"���((v�-a���i-*1	��/Y(�s��ّ�,Yd��y˔��k<lt$p�U�߷����[��?�mku	WK���AV��w��onX-̗�ơU_��j��=�:
�Xh⋮�5�eBw|����d��HLY�}�w��j��=|�|B&fO��I�e�F�E�78 ���{�M9#�'3J>J5��܊w2e!�N���,�su]�ܙ�L�.�Eї�R���؎�O��Κ�I�P�pBPk$�喞T��SKC	���*�ts�U��U*�׏�_�T'���	#�l�t���F��2y�p��%��j�HY̫JF��T�;�Fb^\+
O'A��2a��T�{�B��C�?��۱J�!��x^�o�?����m}�7\����Yk����%�Ā=�dRn$2.K}������p���6�B*��9�#�u)9�#�u��Z�k�.gᚾ:�H)QI����K�0/��]Q��wX�a��R����@B�2c?DRڤȹ�7_r�-q���tw)�N�D�%���H]}+�&�n/����
�����j2L
�;q��x���8�l�ӊ��d��Y�ҮZ8�D����_�C%��ȋUY��|D���:=KX<V��p����-b��j��e�E�
�B�F��)7:}�RW�b���,\�������Uw�7�+�RA!�N6,����F���j��z�Y�g��kg�,ίY���I
�,yxg��^��J-������Z��<xշW��l�H�,�����}ʥ��
��QP���q�0�W�ȕp�\R�d�ג=�vv�R����}}OI~����Ƽ|C[��jx5Oa�o��zR�^�߆�v�T�-73�԰��F�Ѷ:Fj�"&9Yv=dw�R�a�F��$�����r@��F
�"�]ɧ�#zgpY�e{���z�H���wX��0�X�����ה�T�~�Q�{T$	Xp�����#�`_5�x�D�S�gpK�k���ܣh+��e}-"�����\q��C�g�+�$<$��<�\Ϳ9=3gKa��C�g�?�Y��t�>���rX֜�#�w}�Fʓ NdϾ�<5�J��DY�J�3����.)O9]U� �o�G�c��#b	�����]�Q��n#��\O��=�؍�)�a�I��/8�Ҝ�B}WO���M���|��6j�w
�9���c��jG�ʓr%�^�n�/�uA��vo��f?s�'0��VJ��OC�QΞ��Ҭ
�^��mnv�~�?!~���U�.<?T�zC[��I��B��"�z�y>
�z��f��8�x�?9�Z����D��l�ZKS����8������o�W�i
�w���k��PY����F7��P{d�`T�a`��^�t�Fz浐|e����$��EPe����~��)T�XQ�*���x5d��US���ɽ�*�Px��f�Մ[x��A�f8��R%�@k@��q`�������	���a �Zh�jCM�r��S�,U����^����d/.�
LS�Ђ�� �O�t����z9�ݮ�)KҞW7�60���������Ss��g5�m�Ҏ�꼛�6�w�
)F��&���.9�+��H&�u��T	.����dԔ*��Ԯ�\�L�E :���c1n�
$�1��	0]�ہ���L�J�v���)U�,=�JL�L,��$���ړ[w�ԃCD��>���O@�u������ψ�!�fvt�c"/'I#��\���Ї���E�8�r��i�Ó�\XP���"�<J�I<\�    \Jr����H�jē��$9��h��@� !�ɓȍ����M9���n� ��׈e�Ϫ�B5}���ɽ���'��h���]0�h���m-�*�=Ɉō������?.�
e��o���Qa�x��ѷ�y~P��HUlĂ�U)�����DvF#ǽ}��I�K�<9�J��ȖQ%R +�^Ok��X�b��vX�*��-�%��C��c/�� 7�؈5^Z��h����9�	�D�t#Vs�4�˹�rf�'~`��ش�A/7b��WO��9�@�8yP|�Q��E�jM�ˮܡڄ6L��9kz��VWI�� �3{aR�����:�)[e{����*�GL�=R�����W��I<���U�W���ť�����OS�+󇃱�G�W�3�ln��T�&���m]������N����;�T�y0��f\4;z;���Fx�ɯ��J�5�K����^�H��
ו�I�*�����$R!�����8����a��Q=���Yf'���3��u5�I��.�B�q݈��#=V��O§p��y��E��I�w�6���U��@{	T�3�9�����8�w=��|n����-���u"i޶��Hu �����v����	>��pZ�1�	$!�
8R���֊�f+G�HU�����'4��z��o��:|�DTǂɂ/�0j��Ό*8�R�$��y�.6J!��G�jxt�﯅U�2���c�"���=Ԕ�^=V���z�p�p�����U��'�*��H��������ۃ#q+b���<p�~�l��in��TWre\���s��4����������^�H^8\`�Ĭҋ�&�oR��|����+��&V���}�-cU���0O>ῡ���&�W,�w�/�E�!�J|Kq����;	��P��Z �ܮ���\�|�y�tE�*I/&db�X(���`��.�m�90GgX����nh�mFDqM��R�ՅFj�j�ʐ��O,��ᏼ�kX0�w���G���H���\�5X�א)���a��΃x�*�c���]�Ld���9\uG3^9���X�vU-��#�r�� p�Ǳ
Y��@yG��6�g�n��M�~-��/�b��~sh /�vh~Y�4��Y�U��w����^����"C8.��(dp|[�?��R�Y� l�p�Z�%�u�7SW߆�y"C^�7&JN��9����^D�"�{�\*xB�yӯȋǃ��ލX�kw�پ�n)W�-�'h��at�����[+��3�Ӑ�������+`yG�w��]�S�O��Ӫ9����{I"��G?���xV<��o�@�,�?T�^�(
�^��$u>�mi�테��y�-�Q��arho�^�Iu� kI�W�L��G�������X�R�m�Y���΃&��S�U5��]��*�U/WL���yċ����"���y�'���N�:E�6���z#�[�����]uIג〙Z�&z�"Ϡ?���͢HED�E�D�YhdO�;5���R �*���?Mi&z3#Ϩ�kV7�'�y�����< ����6��n=���44pvya���t��b�N:a�B1����뮓�+t$��Bǡ-Jz���0\��:�T{���:+k��8y��A�}�wԖ?TEz�#��r��A������c��c�ʂ�k:M�=��d集U��H��G{%*#��ވ���(�0� ���S����Ԍ�]zO#����T����l$z�$��tē��Jc7<����#�+)����#���L�G%2�����[j��\�蝖��z8�K �ɖ����"<,f��%!���?k�*k��L�/vd�����¶9�l��frY��}P%D��k��T�@P���-�{G�_��'G�u����c�n.,	�V8�)��A
���^��3�.+�d*Zy��!2n��C��o$H�����K�Α��׹���b����,�7�jD'�d�d���jſ��[��Dɮ�D����v����?U�Y���t���J{�zŅGfvQ�D��%��ˣ������$���0��_�Պ��j�S��<�s���#7�@�tǘ'�������`m{����A���<}�cuu%�G��y����	l�fZ�Y�^��T�X-����>�K�d>�8�q���O%�;q��q����l>B��
�ܟ{���L�^�rm�#���eKt�����2�U���J�=%k7ne,0x.�VkjHݡ���/�O3�D����O�*�Bv)��MӅyݏ���, �����*���q�Y�^��n>�`���-��;�����|c<���Q��@�k����T��9ݰ���o��dEZ��m��wS�j�*�j��y@f��0AK%�j����כ}�IS��]V{���1j�&դ/�N��z�Y�&^������{G�RM�̴U��6�ǃ�S����M��ܚ���^�}���EV < �ι9T���T�<=�F^[5�j>�G��轘��sz���{d�*}��w� �������~̗l,zh�J�S���ky��s}Ӈ�akWU�&���J}�TӶ<|���;���G3�ն���Зj��ǰ��jv�g�UJ< �aV(DZ5U�_�rq��Y"�{S]!K5��cگ떌����t����/巪�&kf��mz��cy��q��pS��S��-]��=k!���A�)U�������C,u���`�^�7)M5y�S��́߹�.W��ֽ�f%�Ӯ
��1"��c���}��Gg�k�~���x��̼�P3p�j:9��Yy�������g9��j^��˟�B�!�:�t���-<^�ud/�7N� �6��#;Ռl&��(_O�Y�j*�G�?���m�`Vg�<E�ߧ ��/�K5�ɓ�ֱK5'����,����dU��jv���?B���5�l��τ�>$�ǒ=�K^��`ʛ�iM��ع�7x1s���T�
�!'۰���CZZ���[��gA��s�S�h����^��,
cb:��)O�_ Nl����0¯ȃ�A��H<��k�����qv^`�h����A��2<��IaGA�'Z��C�	[:������;��ԂI7l�h�\�$Z�3���5�t�t0|[:��t�� �զ���DǓ$���$z�?��k�2�o�v���&b�P��VP�S���I��>Fw���db;�p\�&��-�7����\ �A�:��%Kӓt�%Y<\~������=`U����^���LZ�Z<{~/��1����ǀ��rZty<�����x-����/�m�����մ�y���6|U���3��f�c˗�����f�ܺu<d�w;|�O��{"�� �|ͻ��Y�UuPΫq��6o?��F�.��E��	�P����c-��1�/�e��sjӮ�V�¯�2//�k�O���_@�N���x�9@���o�ˊwSX�,��T���wτ�jBѷ�Y���6��~Z<֚)���� �~hy��r����4r�3f�j
��6��mxQ�j�
i|���p�e<|_W�C�+�<��i5��t��"�G�?�s��a ��ӥ�[4[���j��%l�K\�^�ܖ����,�9�������̬n���)�}��!��'��ْ*�U=�g��r��)gŌ.�m�~� ��^6i N�离��7V�Gr;ڿ�o�?EKoa��n�t+�&��{<���c����=���Myt_�9x��\8��^�V6��yY��X�BãK�D�}�}E���b	�Q��
��+��)����*EG�>(�u��_rs�/�I�: s'N"� T�e<�\߯�0��#��)H�Z@�յA�N��rP`�[ ��o K���*�������&�1<g�L���;E&rE��(�Zu;5�H?	�6r��,�D!/�57}x��̧�Ê�x䪕Dn; �<��%�U��3{��9��ۄ��]6�&^��I��G�����;m�Cv*Ҽ�gN������w8bׄ"mM'�$�� �  �d��?���P7?ͲCe!p7x�
i�;��XeNF�4LP,�M6��"�i�g�U�&̤X�^b��'m�E�I���>S�kΓ��U�V�u���6�A��-(�%��7��"Ɠ`�ύ�E���BX��������L�Q�g����X�_L�B&��,�%��әQ3��y�:d�8ͨ��,���8|��w�<i�^i�"CB��(��}pK� 'l々��xn�f$F"���M���(����g��`B�����-׽L��V���=e�QN���Ee�Q�/��w���);r�P��y[bT*���l"_���5�]�cS�Q)(�����(��X�l�q5X~���k>AE�L����u3�	T�Y�=����t�IBԡ���r5�-�A�� ��D�� �M5��/K�k�^��5F��I6�tt���{�-��*~���x����N�h      �   [   x��;
�@ �:9��KQX��M�()�H6�ߵ{L	�p<���E��e�X/�3��ќ��U���5�f~��=lo��p�@�M��y�D� 
��      �   !   x�3��/H����2�t,(ʯ��Msc���� ���     