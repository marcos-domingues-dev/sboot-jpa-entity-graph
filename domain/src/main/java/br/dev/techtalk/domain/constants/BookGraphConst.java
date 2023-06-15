package br.dev.techtalk.domain.constants;

import br.dev.techtalk.domain.enumeration.BookMemberEnum;

import java.util.Arrays;
import java.util.List;

public class BookGraphConst {

    public static final List<String> PUBLIC_MEMBERS = Arrays.asList(
            BookMemberEnum.BOOK.getValue(),
            BookMemberEnum.PUBLISHER.getValue(),
            BookMemberEnum.AUTHORS.getValue());

}
