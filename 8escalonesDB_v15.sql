PGDMP  2                
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
    public               postgres    false    225   Ձ       �          0    16927    tipo_pregunta 
   TABLE DATA           ?   COPY public.tipo_pregunta (id_tipo, tipo_pregunta) FROM stdin;
    public               postgres    false    227   @�       �           0    0    admin_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.admin_id_seq', 1, true);
          public               postgres    false    218            �           0    0    participantes_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.participantes_id_seq', 21, true);
          public               postgres    false    220            �           0    0    preguntas_id_pregunta_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.preguntas_id_pregunta_seq', 520, true);
          public               postgres    false    222            �           0    0    respuestas_id_respuesta_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.respuestas_id_respuesta_seq', 1965, true);
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
qXx#�i����M6��mg;��n���N;nq}���B9���s6 �<r��ǽ�3j���f����r�1�3tǤ�1�u)J�u{A�;B���aG��|��K(�/Q���[��dw*,h�+Bz�Wb{`I�@@8	��}�-F������������      �      x��};s�Ʋ��
Xk�h���53���{b�b7��P@��]s��������7�X���~_fUMR�:'$VfP��wfUG�*�*Yq��rU��i����|ѮЎ�v�
~4C]���������4б<.�����w�{��G�˰8�ج�M݆��ac��?��ux:ܛn?�� ϊ�D��JZ�˃rn��U_̦���[������*x�5]xZ�i��������C���_�n]w}���4m3������˞O��8P�����zA��q������}?ɂ���f<zL$h��(�L�2(fL�����u*�Q&-�Jb]�K�jn�~?ί���;U�,�`�"&�`��]�Aɠ<�hv}��j�z��E���4Xܾ����QZ�&%�|*��+R^:�#R^>���m����ñ���[�h�OK�y ��bI,>O����g��}�-
?����̀�������c=���eP|6��᛾{8���3�
>�|�}����t����f��Fe�oʔ=2~�j%m��vM\;!>��i�۶f_�!S"ϲ�ո�������
�ڛM?���G02|N����u���L�)igU�37��o�M׬�!�����ِ�<
��}^���`����v2��<�F���>��2L�'m�3ݲw�xg��������2x���>�h�Hfc1�����,H��c�)�ܨb%m(�Q��os��>%�f�BE��LN�u�����`ȔM�jA��	x�׾��#X�$v�$�"q�<R&�#r��2��vmHժ��U����m��al6��Oc�$������m�6��_�n��P9�a=� | ��-�׮�v#n�؝����#��!�?7��\B������.P%6A�ܙm�:%���"4	���7�kg�����U=�j	(�s����*�r�X��ܮ@_�?���:�����gA�,�IĜt���Ѭ���#4��t�6�ch����m��p0Ν���{(_�g�]s��"�K^����C
l&VY���1[��<�
� .�E(�{�!Z(�y#�*�� 	Κuۇf��ǫ�w�C��D�vw��j0��mݷX�E��b�A�K�V���͸���P9��zx0!47���[l��U������	T�@��@����]l��P��� ��v�"��d�r[l����0Pc-��4�u[+�#�S�laL8L9c~��(|��rj!N/[(�S���5���)`���e���1A�θv2��[���)���1빙?�Aq�a��W���O�I!+� P�����O:t�v�D��`|��Hy(���vS�iA�9��Cc��~���0�fA���A�G�Qj����)P��s�R|V����Ꮞ+��'�\�=P����N��¯�}?b�7�)�e^�]!�~[���d�:U�7�3U�C�8>� 3�L��j��~�w3ר܇r|`V��d5�޺����=�F� �����\�hS��\m�&{��m�U�[e�[���-��\�)�� �Ϧ���B�T�E|���d��B^]%�+�OP������)T2`d��Ч�YTE �V�4�2@�DU�A�IĴ߂r%Fj~��L��,���7��F�b�ʴ`L�WI�C���T8�_A1e�EQ��������~LI�'��|H��`X@IZL	���x�i;��(�1z����C���P���A�B�q�e0�ȉ@����1ᛉ:;�8u�¼L��� =��k��±(_�zߙ��/Pg|�qﶹ%���<��´�6;�
����P���0�fqs}�IaC����f�P��ͯ�-��S}=L�pD��4�r �)5��ók��>���!3jwشݾ���o/�-�L�-�*��}M	b�%��o|��+Ȧ-߿~}��]PR
� @|����I��������3oeS���'�wYI���趙�v��@�6�	V��߻-dK%\ ����y=��MHǹ!�#*�7�6t�K���-|9��7u?l��g3�g���.����|O.��.����� 8&	�\cM��}}�4�����.<٘��`�_�l%,��4[	sA%[�Ys��Q�������*�05#��kP	�A+��;B����y�A��� ��]�N�Bq�jt%\��G�t4gGhP2�R|~�Ǧ����~�Hn�0t��=�v�F9Q��}�@S(��������� q髠n��@@W�-9�yۢkR�V��f��A%��Z��殟�؅&E�7��d�Z_���Ƿ:HF����_�9N����-(�}�^�[`�1�"�|���Ǘ~�@�C��� Ӛv�q �^N�w ������D��Qe�#�~�x {V���Z��9����VraSj1�q�1[	���0����)+!���J/�M��&���,�U@�͒��`Y>"*n�J���LX$ħ0>HߌM���J�1c3���S�fp�2%��q�H�T�)E2%��	ac�{�/�f�n9]������|�I{dL��MH��y�){	�(	��@⌇���L4�]��b���yp��+2�@�d����t$D�	��4��3�
>����Ww��}@cP���NX9v
Oi�{`���;����P�{�ɞv0�Ba�5v����? ����Ѹ"x�L�1@��I��1�ƭ9���E�������ZGq�|;��Tc'�� ^!�����%�`�hïf�!U��|h|�p�V��4�,h�����kh[��M���Nry�j1#o���!
/�z�wZ;��* 	>�m����>4�
��n!��A��)�)���ᗮgx!f��Jڥ����T�5��(��_w���Fsö�5���V'�x����������y�c�D����~1m��~�l�ү�-�)z��t$�c�?��;m���O<S��sA"���)>��:����!��Ӆ������4���M��w�ǆ팇DX���S�$B��|'�_��s��/z��no빝�,��B�q�6�QxRP|�z�*�ذj��P+�a�}��V+]8���os�X@g�L`���R�"dJo���l�
� ��n�v�!��X��4Ö�3��b�\�
��c�Io��PR�	�	"�4&P��AAfԅBP��K�.��6�HZR2FI�,���%H/���O�/�G�+����d2 ��Q"�oU�4a#	�$T�)5��_(@�U�#t�bj9��_����%��P����`�s�AH*�"�	�� �H<�t=c�G⥧���O���3���y0wf���[ dX?�u�����i���0��L�A�}�7pj=�z2.���A }���k��C��=���gjHF6"�5�؟���C؏��Ay�nw;0���YF�@J(�￉Ȑ�E
�83�v�Z�7C'p�A�5��$֑B-~m���G'�H��[ׇ̽�B����e���5TM7����KR����{�[�����]�y��k߬+CRJ�$/�=��=���/����]���U�-��pMJG�O�Q!�D�7g荒��~3�ީB�����>�'�{��n'wͶ�;ߧ�6�ށa|Mb)V-��;���f/0Σ���8�^�C�߷��/���痩�O�YP�6��(�K94��\�d��T
s���"�&��9YOf�[�A4��q=��f�W�/4���R��7C��ϔk!�cv�HX
��Y���Z0����-SW�Z_�]�y���I�����(��' H�7���`!�bs�;��o�P=8�Mo|3�[����T?x����$��ҕl����`>�2�/���Q:�ał�-���X3#>w���&�:�rc!��Pγ����-49�(�,��p!x��G�n�B���piq-�p���(�baʗB���H�Ғ����1�GǇ����K�1-YKI 1�Y�� _
�J�����V%ܖB���#�����+�*���F�J�]�-�$B�f�o�3+Il&�V-E��d�Ժ�'    I�XS��J#�
X�)#�� �FIQM�Sf�*>5��L:�=�˸�x�Y)k�����A,�]&�V�c�˰&De�7_�K�Ѐt,N�%I�(�QIM�8�Zx����8�A,�{F��Z'3���b1�3,g&�p&�6k|���hp�X�V�3_��q�3��y�&|��l9�$
b1/rY�{ g4"�E��%��Xt3쪠z��&͹"x����!y�B%�}DI�X.���]h8����H�+����^��gC��"�rY������p����9T�� ��c->E&���qV"!UťM��N�2�]w�)� ^i�_�38�1�������m�(hI���0�C��o̰f��#�+
����H�a?��$<����}x2��(s��������Aq����z/ɶ$�O�k���S�����w���Ii-
���x%�y�?�Y��dz��T�Ų]7΁�W�A����[O���RU�rx��o�������z�Q�׿�(�>����ߟG�]Yz�c]@��&�����^Lӌ�?���1zկ�>�ī���#\������`.��Q����	_uu�VV�T�U�<��A
��a,��.L������^�}�4�I�c�*����m�4|;m������۫4	�b}�k������~��8͔��_�@�~�_7��m=�v#h�k���;zY�ofL��C��`�3��E������2��}��iJ���͖�-����^Q�}��͋�g��8C��dk��&�ҿ}��\�Oï5)"�\#�I��k�[[�BF���C�ޛ�iX�����r��"|��3`�O'� �l
�P
����J02�A2�~�2ɾ��������^��tL�8[�����݄�lrd ��o�f�P���b�?��i��o��z X kxs����sL�~�R
܄_~5d�H3�P3�@p�>|[ﰵ��{�Ɉ����wu{�XϨB�ˏ��Q*`�_݀C"M�B7=�b�g(�'kk1
��k	����\��$�T���ɏ+��.=S%�6�%�H8`�R������2�H�SM)j#���|V�:l�D�Z,��/>�ᗾ�i��T0��8{q�%��)��7���/@���_ɐ3<qL"c!G�������TD�|{7�Kt���t����o�ا��aJJ�u���
n�6���Meǧ����K5�Fv�t��E_�PЈ)`M$���1L���w�"UWh+Rif̲&�'
(X8"�hz���4*�$���Q�LAk��JD$��$\[Кa���A"4_���͂n��q2F�� �=.�RSq�lA!q�D���-���LJ|���u�H�����O��-W���+5�K�I�˵���'����]P"vr�K ]�2�T��'ۃ��&��`f�Wb9P��OL��f�����rݒ��z��%b���ܗ�$�a����q�|.2t�"��~���3yV�bQ$�a���v��v~��e4F��h��j��u�N�<��(�G�C�$I����`k�<]V9 �3XA"I֚S��&d$�e�ya|:�sMG��.�gfqU�N+��@��{ȉ�G?��=X��=,
~:8���,����sȕ��i��k��!O蔙v*�-hE!�-sm�fX�*J�����ְkCq��Rɔ�;Œ�wX��r4d�ڮ�xZ,M�R�$FX��nw*�=$�eU�]�%Dh��������`pE?�21�ຨ���t�*8��Z�����
rg!#��x|,=?;|'!	ØPq�k�G=y�`�5l���ŋ�8�,Kw�v�,����d�1�e�P������'+l�f��ʪ��Z�O���k����,��r�/F㛠�o lo��A��&�i/{��D�K��'����M�|Q�ɺ���S�4��g�3q�˼|Z��FU��J/��vцU:H�.����x�ߌ�DR'�9	?RE���<g���]ri�YH���$j5��	����~诚Va|P��ڭd!�^���}"eߥ�BH$���x��RmBR��7���}�sf��'ui�Z�c�p���D(�Q��y�6��L2����J���JRN��bb���U�]BTu�^,�����r�DJ���D�!L�t���!�יN�|S�p��ӹ=�ݛ�*�&��i:��s��@��\@�.x���0ƨ�a7��l$ڏ���@�՗%b�}�@��g�>e����ր��( >����8�����Oj�P��9*u:[�I��]=���W��f{�����'���O�[��,6^�k�U��	�Cg�wIl�Y	�%;�1(��ms:�	�x|۸�ávf�XCOK�BL*�IϯY7�� �u�X���O�2�����a��h�����Q��~�'h�M-�.	Gz��de�0�AL$�8xw��Q`��T�����X����Q��BS_��/�̚?��?�>���q"�tb��0Z��N�a]BߥXvYVM%��_���w ���cԉ�K՛�1�D����z���9�� ��y�����aG��/�5���V}�����_',�)����p�.N����D
�鸞���{���\1U(j����������8�<1=է�ȉԴ���������ג%~cd�
�SXL,$R�N�����d1$#M��|���z߳����?�-��B���b3+�Hu;��fk7��_s�f��&M�%��[�� v��b�Dj߫GՒR�Hμ��JI7��T�#B
-��#T������C"Ix��R�f��$2���R�d�+Z0N�K(�'�^7�y��E��a���ˤlP���� �E��6{�K�M��x�A�ݵ(��K9��H��'�. ���^ ������ȗ+,NAw�fJx6�݊i$��J*D�/�I��gPI�Xo�1�wQw�@�-
�~vF&)|Q��*�DR	UQ-�Vl������^U�H��������.+ۀ�F.v]SX��>O�K�&�m�JW��HJ�٤̓�F~%��^����l]P"Iv��yÚ�^Ax���rK��w���[�*��[C�=�*ֲo��B˰aX��k�������	)����
![�H
��J�:���c�y�i�@�X�CX8w�p�@E��))�\!+8}iE�g?V��]�0խ�{�ޤ��~�e���.,��!��S��;~�Y����0�a�l��-5� :`�t�1� �{��QÉȶ뙓+W��u��$��!�_�h}S"yu�S_�艕L�'U��{��<�UU���q�$܁-g�����5�G�snl�t�uI� �����a"�y`�#���ܓ����
fɲ�R��G��z�FV�bYn�s�4�"rWk�虞U���|֌�9��/�U����=���a�������S/.�e	�8����M�H���T~�@��II��P�Ny�F�3������W0,ލNV��@r�Q��B`Xx�ȁ`G2pv��`:
�Ҟ�a����Z�1�"�w#��;���z�I����z/pNք�g5����)��R=�>�oM;
T�T0M"oxu�������l>�b}=1$��VF���f���<��������4���f+��9���ǔOvfSOch<|���5I�|�c.��@��>�by��+��x�?9�U���PE�*`l�ң�Tƃ�q\���9��_� ���))��a>|6��"HJ�<>.���䙊B�L���r6���K�.�HO�R,4��Y҂�Y<Qֺ%P6,�%�r\�zp�XJ�
��T+�G��=!�����nA�ឩ�f8�$�r��OF��m�*�0�uM�Pf=7�-��-�J*�{��_Rg���������]	�$%�2-��yp��r��~�o�����6c^���k6AR����>��v��LxVS�V����O��4a�{7��ڬ�a�v/��C�*8�T�BX�T��X
��aQA�TʚU��\5����'�i���~M�X�[������=f�v;���Ͻ�%S{|b.��i,=+*eL�LL�wv�d��d��#��    <9'�� U�AK���R�J9T��A^2�~�s,/�"Z{��.���,i\�j)��UĳD�ZXP����<Y�E�]B]Jp��O|um"%\�4��@VēFZ��PBP\{߅ޚf���mM��iB9 e~rK�v�u��ı��<���s��,��'Ii��|��R{ӱBqr�x8|߈�:B %�g�M�R������OU!���G���#x6wܛ�:|�\]-�`u��"�z������T��X�cZ���˰R�j���[7#���0��\��#��OJR-CbYâ��C�eJ�UL�8�%���G������ҏT+��=�O~H�4O�B����0��aژ պ"R�_��]���x�UO�7|���c��':�!�F�$���/�V#��qY�GeG����+ܙu�q�`�5WMo�������&��J����e{���x��f���)*������V�?}��>7�Rq�Ԭx\��)�����؁�U�Z{��J��Y"�<�˂!�?v�/X�'�l��3�v���˱�7[�`�>)J�(Q��/=���_�0�g��JnR-g��'EF�&���3EF�����fd)L�c	�Y߄?��f�Z����-p-���
FF�s���]?m���DP8DzT�j-�Vs����^�ι���"�x\���B[>״2q�,K-<��#V�
'�~,�� j%����ghLi΅��� �$�����Z���\Wj���c���1OJ�<&�4è�9S$\0��1���̃ͳ�2�|�`֣��C+��Q/�����詤t�؎��f����~2��W��?}d�Z�Ģ��jK���iύ	��ՙ5�M=cK7��S���\ɽNZ��2cl�4h\�~������˳��`�1s�����W�7)�#� �팝Y�m�\�&O�?"Kk~�OԧCd���,�!їf��������K$���w�zqC�M;�����vݽb�\�z��-��$�=��>b!X���}Qq�/S͉�~	�On����f���)'�9�$��&��/�P�_�Z��7�p�g^�8ly��0c
��3��~�H^���>4��|���S^�G�A<����uK��2�W�� ���Ӌ���h�o����89�������ф� p��"��>L�� ����[��k:����f׀_����6�+)��T�eF��ώ�]�)aE:����}?(P���m����p�zF0.�	��k��,����w�}�����R�5�Hw�
`)/�QzyY����^ҷ�K��_6��{����̪ji��]���"�����$�ލn��#g��c���q�xd)�w���T6�Xޑ��"*b�ޙ��봖�#�Ǒ���dF#��O����'>���0������4գ{�C��e������Ej�u�L�\�}��ְnw��Tw32��vկ'��\����S�}g�-T��>��E��s�\oTL:8��i�F�.��(\���@����k- Ro4���x���@�<��G����d�p�kx��!ْs0�]L�d�1)+�듊��t�7� �[�RWt�H�����axrW��}���/��^�ƃ�0��&���3���WW���T���"�@'�l�G%��]��<U.w�^��TC��tBD�b25�?�]'W�Lr���:�hQ2�`V�W7p[gp9�_TG(�p)�k��s���-�&���(-(~*���5*�/<1���A�2
�5��1��c�̌�i��{󲇒��֚�=������Xs{m!�r���x����A2�
K3�w�}J2%͕���6ߒ�-p���Ԍ��3�MYx �ϡ�;��Ƒ�)�G�0���(�BdⅳV����g�|V;Ջ����p�� �'��!��=,fe⚅*;���5x����i�|��nk���w߅m���P���D=��}��N��k��L�@P���-���/Wƃ��(e�^�ǳ�n-l���(�˃X�cĩ޺ǃ�.V���ZE�X!J\V�C� o$H�����NK�Ƒ��������XH9ӏ�!Gb�10�~$À舐,�d�Kh�P�KM)���+J��^�ധ�%#襂<�����Lr��yTOW:b�s���M�Y�j�]a���7��-�|5���fѱ
���gh��kQ�[>#����4��c�.���Bk��>�� ��3���l��D�h֚ea�����i�swV(C��Ĭm�[.�]s�<K��6�O��<S{�@��	����%�%k�9cX�� ���^o]IFx#w����ݗ ��5�V3�h:�#��+��=YQrO/c��r��ZSBj�8����eb�6�ts�峐��!��~nSua�T��YĲdh@z��-�FA��XI}���O�[�fҔry��q�j�Gtct��X����ik�9�i�VN��K��s�ur�o2J���]��y�o�ߌ��X�Zkf0/x�BM%�i�9�{5O����s3׬�4��1����t��t=$YП�^�e������2g��b����8T�� �Xn&��V�e+{w�jf�,x@�7�k�3�?�L�Y�!o���4�C�K����ypv�5��=2����� �
Ӆ~�+Y��nCg�C+W@�i�8��|+�����T��rkwU�����Jm�LöY��]0���:pb	����E���LC��7^ed�͊�r�<g"�j�p������k�O�.�=�TDs����L��Y�lRKBh�jx�����w�[�B�=���ʫLñ�b�Q��0U�<(@޶�B�wb%#�X	9�4�ʫS��py��!�w������^�7)V�4x�{	���sc�G�.M��uL|�`�1mMxe7�x�'(����	J�[����yXa�㥏C0�6A��L�i�dg�e��ք�W�\OTrl&Ӹ*�?8���3(����i�ٗ[x�`���n�8�v�T�ڄ��"�L#��x�"|}����LC���u!�4eD�U��Q��) 4�K3�u摿F&Әh��f��*BI���FGs���ڄ���d�c",�!���̃J�t���$�9�ְh��~�3�+Oe���3���l�<����H�!Yx���9<ӈfΛ����W�`�ә�N�*�e��;F��s��L�>*��_l��*��T+��[�R-���*A�<y�[���^v�Z/��mN�ҥ��,8]>^�¦���	���V��\G�Z�����T��"�︰���������e��έ6u>ph�%:�4Ֆ�'�[�3M_�i��ߎ�R�r��f��!����곜7�9��}t�\L&�k�E>nkUY�Js�	���.J�Q��nY�Šc-�3G�J/ll�5B��簛�=���Z6��'Z�c�=��y�& �E7���j�k�6����4�}��̯��~��ʥ�}��l��I��A#ұ�˜w�(�r���2ǻ��M&�DB�Al�*��,�ʠ��x?<�m^Q8����A���b�4 n/i+�Z
��K�.��.(M;�GŁJ�[J����i>"�*���l�����ם��{P�	B���.o_��Y&�R����x"t�L���?�*Ŗ�yͣ�x��\�h�e��ɟ�q���Qʁ�S�c
?�6+)�{��v�������q���y��p�5�]�{E<��i%K�t��N�w�\�S;�� ���ܔ֑�T���XX��T��a�R"u�\s� ��t�*�U���+�ҫ��k&�C2��˷�9T�x,V�,r��`Ōn�mW~� ��A�4`���z)I�U���5����j�c��"lB�[ 䈣a�x\@SG����GbM���Xs��Y�pX�b��*x��l��4�^(�xtk�S�Y�b_'���3,�JT��g���G�j*����v�uɞ;L������[*�$ Y�qJ�R�J�KdP-��A�����e	�F��ϻ�[^R�%(���Ȼ.� w@(0W&<�m���af��?aT�sã��\� �� �^�n��Z12N\��\t<I1�C�q�Mͤ/�����~Xt(����T�` �:�U   �4V�KW��<@N���:<��Ib;L�0?�X��Ʊ��G�����Ҽ��'a�����"�;f8beW�f�k:ɓ�ʏ%��KZ�!n~�$Ce!07x��2)L�B���ln$A97xb:�0���6[��(�ե�/�Z7�.�ho+Nc�&X��j^Q���gb(
7��3���`I�[P̛��Ǥ��X>�
_�(_�̟���r?,�?�7C�%O��Y>o���73Q&����ʹ���cF���"z�2v��(�,���8���{���r�eZJ$��;���rD6XJ)?��fh6A�(CR���[�X]�(��v�3Vo0��`��ܖ�^��yW����i�����L%�2}�ۜ~`Ɓ�%&T�`^�&��=i�d^�w*}�"1ۆ�r�+M���q�!M��a,�Dv?!�O~�2M�5�6�����?T��O~�ң���ހ��<i��e��H��/����ڎ�G��RH�E����&������Ꝑ�-�\*~��{��?�_��A      �   [   x��;
�@ �:9��KQX��M�()�H6�ߵ{L	�p<���E��e�X/�3��ќ��U���5�f~��=lo��p�@�M��y�D� 
��      �   !   x�3��/H����2�t,(ʯ��Msc���� ���     